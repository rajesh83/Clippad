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
		
		int clipIndex;
		String clipIndexSring, mode="";
		UserBean ub;

		HttpSession session = req.getSession();
		DataAccess da = new DataAccess();
		
		mode = req.getParameter("mode");
		ub = (UserBean) session.getAttribute("user");
		
		switch(mode){
		case "list":
			String[] clips = req.getParameterValues("clip");
			ub.clipText = Arrays.asList(clips);
			break;
			
		case "clip":
			clipIndexSring = req.getParameter("clipIndex");
			clipIndex = Integer.parseInt(clipIndexSring);
			String clipTitle = req.getParameter("clipTitle");
			String clipText = req.getParameter("clipText");
			if(clipIndex == ub.getClipText().size()){
			ub.getClipTitle().add(clipTitle);
			ub.getClipText().add(clipText);
			}
			else {
				ub.getClipTitle().set(clipIndex, clipTitle);
				ub.getClipText().set(clipIndex, clipText);	
			}
			break;
			
		case "delete":
			clipIndexSring = req.getParameter("clipIndex");
			clipIndex = Integer.parseInt(clipIndexSring);
			ub.getClipTitle().remove(clipIndex);
			ub.getClipText().remove(clipIndex);			
			break;				
		}

		da.updateClips(ub);
		session.setAttribute("user",ub);
		session.setAttribute("count",ub.clipText.size());
		resp.sendRedirect("/UserClips.jsp");

	}
}
