package com.admin.servlet;

import java.io.IOException;

import com.emtity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		try {
			
			String myemail= req.getParameter("email");
		    String mypassword = req.getParameter("password");
		    
		    HttpSession session = req.getSession();
		    if ("admin@gmail.com".equals(myemail) && "admin".equals(mypassword)) {
				
		    	
		    	session.setAttribute("adminObj", new User());
		    	resp.sendRedirect("Admin/index.jsp");
			}else {
				

		    	session.setAttribute("ErrorMsg","invalid email & password");
		    	resp.sendRedirect("admin_Login.jsp");
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
