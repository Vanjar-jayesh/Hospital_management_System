package com.Recepation.servlet;

import java.io.IOException;

import com.db.DBConnect;
import com.emtity.AddPatient;
import com.emtity.Room;

import comm.Dao.AddpatientDao;
import comm.Dao.DoctorDao;
import comm.Dao.RoomDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddPatientservlet")
public class AddPatientservlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("fullname");
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		String diseases = req.getParameter("diseases");
		int doct = Integer.parseInt(req.getParameter("doct"));
		String Room = req.getParameter("Room");
		String email = req.getParameter("email");
		String mobno = req.getParameter("mobno");
		String AadharNumber = req.getParameter("AadharNumber");
		String address=req.getParameter("address");
		
		AddPatient P = new AddPatient(name, dob, gender, diseases, dob, Room, email, mobno, AadharNumber, address, doct);
		
		Room R = new Room(Room);
	    RoomDao dao1 = new RoomDao(DBConnect.getconn());
		AddpatientDao  dao = new AddpatientDao(DBConnect.getconn());
		
		HttpSession session = req.getSession();
		
	if (dao.addpateints(P)) {
			
			session.setAttribute("succMsgd", "Patient  Addes Sucessfully..");
			resp.sendRedirect("reception/AddPatient.jsp");
			
		}else {
			

			session.setAttribute("errorMsgd", "patient not Addes Sucessfully..");
			resp.sendRedirect("reception/AddPatient.jsp");
		}
		
		
		
		
		
	}
}
