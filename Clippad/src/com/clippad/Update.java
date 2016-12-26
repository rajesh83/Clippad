package com.clippad;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Update extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doPost(req,resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		UserBean ub;
		String result=null;
		String[] clips;

		HttpSession session = req.getSession();
		DataAccess da = new DataAccess();
		clips = req.getParameterValues("clip");
		ub = (UserBean) session.getAttribute("user");
		ub.clips = Arrays.asList(clips);
		result = da.updateClips(ub);
		session.setAttribute("user",ub);
		session.setAttribute("count",ub.clips.size());
		req.getRequestDispatcher("/UserClips.jsp").forward(req, resp);
	}

}
