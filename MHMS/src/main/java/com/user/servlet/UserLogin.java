package com.user.servlet;

import java.io.IOException;

import com.db.DBConnect;
import com.emtity.User;

import comm.Dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/UserLogin")
public class UserLogin extends  HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
try {
			
			String myemail= req.getParameter("email");
		    String mypassword = req.getParameter("password");
		    
		    HttpSession session = req.getSession();
		    
		    UserDao dao = new UserDao(DBConnect.getconn());
		    
		    User user = dao.login(myemail, mypassword);
		    
		    if (user!=null) {
	
		    	session.setAttribute("UserObj", user);
		    	resp.sendRedirect("index.jsp");
			}else {
				

		    	session.setAttribute("ErrorMsg","invalid email & password");
		    	resp.sendRedirect("User_Login.jsp");
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		
	}
}
