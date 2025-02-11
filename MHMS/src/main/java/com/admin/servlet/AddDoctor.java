package com.admin.servlet;

import java.io.IOException;

import com.db.DBConnect;
import com.emtity.Doctor;

import comm.Dao.DoctorDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addDoctor")
public class AddDoctor  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String fullname = req.getParameter("fullname");
			String dob = req.getParameter("dob");
			String qualification = req.getParameter("qualification");
			String spec = req.getParameter("spec");
			String email = req.getParameter("email");
			String mobno = req.getParameter("mobno");
			String password = req.getParameter("password");
			
			
			Doctor d = new Doctor(fullname, dob, qualification, email, mobno, password, spec);
			
			DoctorDao dao = new DoctorDao(DBConnect.getconn());
			
			HttpSession session = req.getSession();
			
			if (dao.registerDoctor(d)) {
				
				session.setAttribute("succMsg", "Doctor Addes Sucessfully..");
				resp.sendRedirect("Admin/doctor.jsp");
				
			}else {
				

				session.setAttribute("ErrorMsg", "Doctor not Addes Sucessfully..");
				resp.sendRedirect("Admin/doctor.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
