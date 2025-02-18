package com.user.servlet;

import java.io.IOException;

import com.db.DBConnect;

import comm.Dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/changepassword")
public class changepassword extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
			int uid = Integer.parseInt(req.getParameter("uid"));
			String oldpassword = req.getParameter("oldPassword");
			String newpassword = req.getParameter("newPassword");
			
			
			
			UserDao dao = new UserDao(DBConnect.getconn());
			HttpSession session=req.getSession();
			
			
			if (dao.changePassword(uid, newpassword)) {
				
				if (dao.changePassword(uid, newpassword)) {
					
					
					session.setAttribute("succMsg", "Password change sucessfully");
					resp.sendRedirect("User/changepassword.jsp");
				}else {
					session.setAttribute("errorMsg", "Something wrong on server");
					resp.sendRedirect("User/changepassword.jsp");
				}
				
				
				
			}else {
				session.setAttribute("errorMsg", "old password Incorrect");
				resp.sendRedirect("User/changepassword.jsp");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
