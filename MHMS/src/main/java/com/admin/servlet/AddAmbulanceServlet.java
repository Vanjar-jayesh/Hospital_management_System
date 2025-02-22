package com.admin.servlet;

import java.io.IOException;

import com.db.DBConnect;
import com.emtity.AddAmbulance;

import comm.Dao.AddAmbulanceDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddAmbulanceServlet")
public class AddAmbulanceServlet extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String carnumber = req.getParameter("carnumber");
		String available = req.getParameter("Al");
		String address = req.getParameter("Adderss");
		
		
		AddAmbulance A = new AddAmbulance(carnumber, available, address);
		AddAmbulanceDao dao = new AddAmbulanceDao(DBConnect.getconn());
		
		HttpSession session = req.getSession();
		
		if (dao.insertAmbulance(A)) {
			
			session.setAttribute("succMsg", "AddAmbulance Addes Sucessfully..");
			resp.sendRedirect("Admin/AddAmbulance.jsp");
			
		}else {
			

			session.setAttribute("errorMsg", "AddAmbulance not Addes Sucessfully..");
			resp.sendRedirect("Admin/AddAmbulance.jsp");
		}
		
		
		
		
	}
}
