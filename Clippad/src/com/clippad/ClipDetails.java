package com.clippad;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClipDetails extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doPost(req,resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		int clipIndex;
		String clipTitle, clipText;
		HttpSession session = req.getSession();
		String clipIndexSring = req.getParameter("index");
		UserBean ub = (UserBean) session.getAttribute("user");
		
		if(clipIndexSring.equals("new")){
			clipIndex = ub.getClipText().size();
			clipTitle = "";
			clipText = "";
			session.setAttribute("readOnly","");
		}
		else {
			clipIndex = Integer.parseInt(clipIndexSring);
			clipTitle = ub.getClipTitle().get(clipIndex);
			clipText = ub.getClipText().get(clipIndex);
			session.setAttribute("readOnly","readOnly");
		}
		session.setAttribute("clipIndex",clipIndex);
		session.setAttribute("clipTitle",clipTitle);
		session.setAttribute("clipText",clipText);
		req.getRequestDispatcher("ClipDetails.jsp").forward(req, resp);		
		
	}	

}
