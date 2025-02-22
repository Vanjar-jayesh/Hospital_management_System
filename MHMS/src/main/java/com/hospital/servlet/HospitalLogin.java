package com.hospital.servlet;

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

@WebServlet("/HospitalLogin")
public class HospitalLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
try {
			
		String UserName= req.getParameter("UserName");
	    String password = req.getParameter("password");
	    
	    HttpSession session = req.getSession();
  
////		    DoctorDao dao = new DoctorDao(DBConnect.getconn());
//		    Doctor doctor = dao.login(myemail, mypassword);
		    
//		    RecepationDao dao = new RecepationDao(DBConnect.getconn());
//		    Recepation recepation = dao.login(UserName, password);
		    
	    HospitalDao dao = new HospitalDao(DBConnect.getconn());
	    Hospital hospital = dao.login(UserName, password);
		    
		    
		    if (hospital!=null) {
	
		    	session.setAttribute("succMsg","Login ");
		    	resp.sendRedirect("index2.jsp");
		}else {
			

	    	session.setAttribute("errorMsg","invalid email & password");
    	resp.sendRedirect("Hospital/Hospital_Login.jsp");
		}

	    

			
	

	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
		
	
}
