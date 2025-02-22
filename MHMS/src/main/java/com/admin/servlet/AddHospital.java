package com.admin.servlet;

import java.io.IOException;

import com.db.DBConnect;
import com.emtity.Hospital;

import comm.Dao.HospitalDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddHospital")
public class AddHospital extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			
			String UserName=req.getParameter("UserName");
			String password=req.getParameter("password");
			
			Hospital H = new Hospital(UserName, password);
			
			HospitalDao dao = new HospitalDao(DBConnect.getconn());
			
            HttpSession session = req.getSession();
			 
			 if (dao.HospitalsinUp(H)) {
					
					session.setAttribute("succMsg", "Hospital Addes Sucessfully..");
					resp.sendRedirect("Admin/Hospital.jsp");
					
				}else {
					

					session.setAttribute("errorMsg", "Recepation not Addes Sucessfully..");
					resp.sendRedirect("Admin/Hospital.jsp");
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
