package com.clippad;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Signup extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doPost(req,resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DataAccess da = new DataAccess();
		UserBean ub;
		HttpSession session = req.getSession();
		String user=null, pswd=null, name=null; 
		String result=null;
		
		user = req.getParameter("user");
		pswd = req.getParameter("pswd");
		name = req.getParameter("name");
		ub = new UserBean();
		
		ub.setUser(user);
		ub.setPswd(pswd);
		ub.setName(name);
		ub.setClipText(new ArrayList<String>());
		
		result = da.insertUser(ub);
		if (result.startsWith("Error")){
			req.setAttribute("error", result);
			req.setAttribute("user",ub);
		    req.getRequestDispatcher("/UserProfile.jsp").forward(req, resp);
			
		}
		else{
		    Success success = new Success();
		    success.title = "Operation Success!";
		    success.header = "Successful User Registration";
		    success.message = "New user has been successfully registered. Please <a href='Login.jsp'>login</a> with your credentials";
		    session.setAttribute("success",success);
		    req.getRequestDispatcher("/SuccessPage.jsp").forward(req, resp);
		}
	}

}
