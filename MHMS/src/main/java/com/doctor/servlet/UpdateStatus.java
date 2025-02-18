package com.doctor.servlet;

import java.io.IOException;

import com.db.DBConnect;

import comm.Dao.AppointmentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/UpdateStatus")
public class UpdateStatus  extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int id = Integer.parseInt(req.getParameter("id"));
			int did = Integer.parseInt(req.getParameter("did"));
			String comm=req.getParameter("comm");
			
			
			AppointmentDao dao = new AppointmentDao(DBConnect.getconn());
			
			HttpSession session = req.getSession();
			
			
			if (dao.updateCommentStatus(id, did, comm)) {
				
				session.setAttribute("succMsg", "comment Updated");
				resp.sendRedirect("Doctor/Patient.jsp");
				
				
			}else {
				session.setAttribute("errorMsg"," Something Wrong on server");
				resp.sendRedirect("Doctor/Patient.jsp");
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
}
