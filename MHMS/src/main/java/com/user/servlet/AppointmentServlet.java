package com.user.servlet;

import java.io.IOException;


import com.db.DBConnect;
import com.emtity.Appointment;

import comm.Dao.AppointmentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		int userId = Integer.parseInt(req.getParameter("userid"));
		String fullName=req.getParameter("fullname");
//		String name=req.getParameter("fullname");
		String gender=req.getParameter("gender");
		String age=req.getParameter("age");
		String appointdate=req.getParameter("appointdate");
		String AadharNumber=req.getParameter("AadharNumber");
		String phno=req.getParameter("phno");
		String diseases=req.getParameter("diseases");
//		String doctor=req.getParameter("doct");
		int doctor1 = Integer.parseInt(req.getParameter("doct"));
		
		String address=req.getParameter("address");
		
		
		Appointment ap=new Appointment(userId, fullName, gender, age, appointdate, AadharNumber, phno, diseases, doctor1, address, "Pending");
		
//		Appointment ap = new Appointment(name, gender, age, appointdate, AadharNumber, phno, diseases, doctor, address);
		
		AppointmentDao dao=new AppointmentDao(DBConnect.getconn());
		HttpSession session = req.getSession();
		
		if (dao.addAppointment(ap)) {
			
			session.setAttribute("succMsg", "Appointment Sucessfully");
			resp.sendRedirect("User/User_Appointment.jsp");
			
		}else {
			
			session.setAttribute("errorMsg", "Something wrong on server:");
			resp.sendRedirect("User/User_Appointment.jsp");
			
			
		}
		
	}
}
