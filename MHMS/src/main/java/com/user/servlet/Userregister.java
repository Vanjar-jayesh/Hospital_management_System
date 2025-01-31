package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.db.DBConnect;
import com.emtity.User;

import comm.Dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/User_Rigister")
public class Userregister extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

		//PrintWriter out = resp.getWriter();
//			resp.setContentType("text/html");
			//out.print("<h3 Style='color:red'> user  not registered successfully </h3>" );
			
			String myname = req.getParameter("name");
			String myemail= req.getParameter("email");
		    String mypassword = req.getParameter("password");
			
			User u = new User(myname, myemail, mypassword);
			
			UserDao dao = new UserDao(DBConnect.getconn());
			
		   boolean f =   dao.rigister(u);
		   
		   HttpSession session = req.getSession();
		   
		  
		   
		   if (f) {
			   session.setAttribute("sucMsg", "Rigister suuesfull");
			   resp.sendRedirect("signup.jsp");
			   
			
			 //  System.out.println("rigister suuesfull");
			   
			   
		}else {
		
			   session.setAttribute("ErrorMsg", "Rigister not suuesfull");
			   resp.sendRedirect("signup.jsp");
			   
			System.out.println("rigister not  suuesfull");
		}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
