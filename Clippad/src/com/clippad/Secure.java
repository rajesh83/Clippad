package com.clippad;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Secure {

	static byte[] getSalt(int n) throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[n];
        sr.nextBytes(salt);
        return salt;
    } 
	
	static String generateHash(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        int iterations = 1000;
        char[] chars = password.toCharArray();
         
        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return toBase64String(hash);
    }
		
	static String encrypt(String inputText,String key){
		 
		byte[] encrypted = null;
		
        try {
            Key aesKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			encrypted = cipher.doFinal(inputText.getBytes("UTF-8"));
			
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        return toBase64String(encrypted);
	}
	
	static String decrypt(String encryptedBase64,String key){
		 
        String decrypted = null;
        
		try {
		    Cipher cipher;
	        Key aesKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.DECRYPT_MODE, aesKey);
	        decrypted =  new String(cipher.doFinal(bytesFromBase64(encryptedBase64)),"UTF-8");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return decrypted;
	}	
	
	static String toBase64String(byte[] array){
		return DatatypeConverter.printBase64Binary(array);	
	}

	static byte[] bytesFromBase64(String str){
		return DatatypeConverter.parseBase64Binary(str);
	}
	
	static String createKey(String input){
		String key = input;
		
		while(key.length() < 16){
			key = key + key;
		}		
		return key.substring(0,16);
	}
}
