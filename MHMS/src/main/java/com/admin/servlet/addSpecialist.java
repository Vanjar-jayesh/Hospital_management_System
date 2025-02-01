package com.admin.servlet;

import java.io.IOException;


import com.db.DBConnect;
import com.db.SpecialistDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addSpecialist")
public class addSpecialist extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String specName=req.getParameter("specName");
		
		
		SpecialistDao dao=new SpecialistDao(DBConnect.getconn());
		boolean f = dao.addSpecialist(specName);
		
		HttpSession session = req.getSession();
		
		if (f) {
				
		    	
		    	session.setAttribute("succMsg", "Specialist Added");
		    	resp.sendRedirect("Admin/index.jsp");
			}else {
				

		    	session.setAttribute("ErrorMsg","Something wrong on server");
		    	resp.sendRedirect("Admin/index.jsp");
			}
	}
}
