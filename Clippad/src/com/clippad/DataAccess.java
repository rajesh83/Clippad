package com.clippad;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.*;

public class DataAccess {
	
	private DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	private Entity user;

		
	public UserBean login(LoginBean lb) {

		UserBean ub = null;
		
		String userid = lb.getUser();
		String pswd = lb.getPswd();
		String pswdHash = null;
		String salt = null;
		byte[] saltBytes;
		
		
		Key userKey = KeyFactory.createKey("User", userid);
				
		try {
			user = datastore.get(userKey);
			salt = (String) user.getProperty("salt");
			saltBytes = Secure.bytesFromBase64(salt);
			pswdHash = Secure.generateHash(pswd, saltBytes);
			if(user.getProperty("pswd").toString().equals(pswdHash)){
				lb.setLoggedin(true);
				ub = new UserBean();
				ub.setPswd(pswd);
				ub.setUser(userid);
				ub.setName((String) user.getProperty("name"));
				List clips = (List) user.getProperty("clips");
				if(clips==null){
					ub.setClips(new ArrayList<String>());
				}
				else {
					ub.setClips(decryptClips(clips,pswd));
				}
			}
			else {
				lb.setLoggedin(false);
				lb.setError("Wrong password; please re-enter..");			
			}
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			lb.setLoggedin(false);
			lb.setError("Invalid user-id; please re-enter..");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return ub;
	
	}

	public String insertUser(UserBean ub) {
				
		Key userKey = KeyFactory.createKey("User", ub.getUser());
		
		try {
			user = datastore.get(userKey);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			byte[] saltBytes;
			String salt = null;
			String pswd = null;
			String hashedPswd = null;
			
			try {
				saltBytes = Secure.getSalt(16);
				salt = Secure.toBase64String(saltBytes);
				pswd = ub.getPswd();
				hashedPswd = Secure.generateHash(pswd, saltBytes);
				
				user = new Entity("User",ub.getUser());
				user.setProperty("pswd",hashedPswd);
				user.setProperty("salt",salt);
				user.setProperty("name", ub.getName());
				user.setProperty("clips", null);
		        datastore.put(user);
		        
		        return "Success.User registered";
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}
		
		return "Error.User-id already exists";				
	}

	public String updateClips(UserBean ub) {		

		Key userKey = KeyFactory.createKey("User", ub.getUser());
		
		try {
			user = datastore.get(userKey);
			user.setProperty("clips", encryptClips(ub.getClips(),ub.getPswd()));			
	        datastore.put(user);
	        
	        return "Success.User-clips updated";
	        
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error.User-id not found for update!";
		}	
				
	}

	List encryptClips(List<String> clips, String pswd){
		
		List encryptedClips = new ArrayList();
		
		for(String clip:clips){
			encryptedClips.add(Secure.encrypt(clip, Secure.createKey(pswd)));
		}
		
		return encryptedClips;
	}
	
	List decryptClips(List<String> clips, String pswd){
		
		List encryptedClips = new ArrayList();
		
		for(String clip:clips){
			encryptedClips.add(Secure.decrypt(clip, Secure.createKey(pswd)));
		}
		
		return encryptedClips;
	}
}	


