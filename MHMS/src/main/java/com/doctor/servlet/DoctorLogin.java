package com.doctor.servlet;

import java.io.IOException;

import com.db.DBConnect;
import com.emtity.Doctor;
import com.emtity.User;

import comm.Dao.DoctorDao;
import comm.Dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/DoctorLogin")
public class DoctorLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
try {
			
			String myemail= req.getParameter("email");
		    String mypassword = req.getParameter("password");
		    
		    HttpSession session = req.getSession();
	  
		    DoctorDao dao = new DoctorDao(DBConnect.getconn());
		    Doctor doctor = dao.login(myemail, mypassword);
		    
		    if (doctor!=null) {
	
		    	session.setAttribute("doctObj", doctor);
		    	resp.sendRedirect("Doctor/index.jsp");
			}else {
				

		    	session.setAttribute("ErrorMsg","invalid email & password");
		    	resp.sendRedirect("doctor_Login.jsp");
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
