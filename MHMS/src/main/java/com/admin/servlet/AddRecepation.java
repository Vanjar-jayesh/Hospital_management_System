package com.admin.servlet;

import java.io.IOException;


import com.db.DBConnect;
import com.emtity.Recepation;

import comm.Dao.RecepationDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddRecepation")
public class AddRecepation extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
		try {
			
			
			String userName = req.getParameter("UserName");
			String Password = req.getParameter("password");
			
			Recepation p = new Recepation(userName,Password);
			
			 RecepationDao dao = new RecepationDao(DBConnect.getconn());

			 HttpSession session = req.getSession();
			 
			 if (dao.registerRecepation(p)) {
					
					session.setAttribute("succMsg", "Recepation  Addes Sucessfully..");
					resp.sendRedirect("Admin/Recepation_Add.jsp");
					
				}else {
					

					session.setAttribute("errorMsg", "Recepation not Addes Sucessfully..");
					resp.sendRedirect("Admin/Recepation_Add.jsp");
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		}
}

