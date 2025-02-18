package com.doctor.servlet;

import java.io.IOException;

import com.db.DBConnect;

import comm.Dao.DoctorDao;
import comm.Dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DoctorPasswordChange")
public class DoctorPasswordChange extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
			int uid = Integer.parseInt(req.getParameter("uid"));
			String oldpassword = req.getParameter("oldPassword");
			String newpassword = req.getParameter("newPassword");
			
			
			
			DoctorDao dao = new DoctorDao(DBConnect.getconn());
			HttpSession session=req.getSession();
			
			
			if (dao.changePassword(uid, newpassword)) {
				
				if (dao.changePassword(uid, newpassword)) {
					
					
					session.setAttribute("succMsg", "Password change sucessfully");
					resp.sendRedirect("Doctor/edit_Profile.jsp");
				}else {
					session.setAttribute("errorMsg", "Something wrong on server");
					resp.sendRedirect("Doctor/edit_Profile.jsp");
				}
				
				
				
			}else {
				session.setAttribute("errorMsg", "old password Incorrect");
				resp.sendRedirect("Doctor/edit_Profile.jsp");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
