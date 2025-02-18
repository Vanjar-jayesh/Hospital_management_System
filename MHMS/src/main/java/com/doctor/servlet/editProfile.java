package com.doctor.servlet;

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

@WebServlet("/editProfile")
public class editProfile extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String fullname = req.getParameter("fullname");
			String dob = req.getParameter("dob");
			String qualification = req.getParameter("qualification");
			String spec = req.getParameter("spec");
			String email = req.getParameter("email");
			String mobno = req.getParameter("mobno");
		
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			
			Doctor d = new Doctor(id,fullname, dob, qualification, email, mobno,"", spec);
			
			DoctorDao dao = new DoctorDao(DBConnect.getconn());
			
			HttpSession session = req.getSession();
			
			if (dao.editDoctorProfile(d)) {
				
				Doctor updateDoctor =   dao.getDoctorById(id);
				
				session.setAttribute("succMsgd", "Doctor UpDate Sucessfully..");
				session.setAttribute("doctObj", updateDoctor);
				resp.sendRedirect("Doctor/edit_Profile.jsp");
				
			}else {
				

				session.setAttribute("errorMsgd", "Doctor not tobe update Sucessfully..");
				resp.sendRedirect("Doctor/edit_Profile.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
	

