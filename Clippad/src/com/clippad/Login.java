package com.clippad;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doPost(req,resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DataAccess da = new DataAccess();
		LoginBean lb;
		UserBean ub;
		String user=null, pswd=null; 
		
		user = req.getParameter("user");
		pswd = req.getParameter("pswd");
		
		if((user == null) || (pswd == null)) {
			resp.sendRedirect("Login.jsp");
		}
		else {
			lb = new LoginBean();
			lb.setUser(user);
			lb.setPswd(pswd);
			try {
				ub = da.login(lb);
									
				if(lb.isLoggedin()){
					HttpSession session = req.getSession();
					session.setAttribute("user", ub);
					session.setAttribute("count",ub.clipText.size());
					resp.sendRedirect("UserClips.jsp");
				}
				else {
					req.setAttribute("login", lb);	
					req.getRequestDispatcher("Login.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}				
		}
	}
		


}
