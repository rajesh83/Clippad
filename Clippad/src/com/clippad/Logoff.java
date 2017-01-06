package com.clippad;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logoff extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doPost(req,resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		LoginBean lb = new LoginBean();
		lb.setLoggedin(false);
		
		UserBean ub = null;
		HttpSession session = req.getSession();

		ub = (UserBean) session.getAttribute("user");		
		if(ub!=null){
			session.removeAttribute("user");
			lb.setMessage("User logged off successfully..");
			lb.setMsgClass("InfoMsg");
		}
		else{
			lb.setMessage("Session timed out.Please re-login..");
			lb.setMsgClass("ErrorMsg");
		}	
		req.setAttribute("login", lb);
		req.getRequestDispatcher("Login.jsp").forward(req, resp);

	}	
}
