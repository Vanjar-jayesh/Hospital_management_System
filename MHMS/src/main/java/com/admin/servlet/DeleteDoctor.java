package com.admin.servlet;

import java.io.IOException;

import com.db.DBConnect;

import comm.Dao.DoctorDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DeleteDoctor")
public class DeleteDoctor extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id = Integer.parseInt(req.getParameter("id"));
		
		DoctorDao dao = new DoctorDao(DBConnect.getconn());
		
		HttpSession session = req.getSession();
		
		if (dao.deleteDoctor(id)) {
			
			session.setAttribute("succMsg", "Doctor delete Sucessfully..");
			resp.sendRedirect("Admin/view_doctor.jsp");
			
		}else {
			

			session.setAttribute("ErrorMsg", "Doctor not tobe delete Sucessfully..");
			resp.sendRedirect("Admin/view_doctor.jsp");
		}
		
		
		
	}
}
