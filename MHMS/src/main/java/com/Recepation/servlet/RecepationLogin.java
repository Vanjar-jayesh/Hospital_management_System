package com.Recepation.servlet;

import java.io.IOException;


import com.db.DBConnect;
import com.emtity.Doctor;
import com.emtity.Recepation;

import comm.Dao.DoctorDao;
import comm.Dao.RecepationDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RecepationLogin")
public class RecepationLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
try {
			
		String UserName= req.getParameter("userName");
	    String password = req.getParameter("password");
	    
	    HttpSession session = req.getSession();
  
////		    DoctorDao dao = new DoctorDao(DBConnect.getconn());
//		    Doctor doctor = dao.login(myemail, mypassword);
		    
		    RecepationDao dao = new RecepationDao(DBConnect.getconn());
		    Recepation recepation = dao.login(UserName, password);
		    
		    if (recepation!=null) {
	
		    	session.setAttribute("succMsg","Login ");
		    	resp.sendRedirect("reception/index.jsp");
		}else {
			

	    	session.setAttribute("errorMsg","invalid email & password");
    	resp.sendRedirect("Reception_Login.jsp");
		}

	    

			
	

	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
