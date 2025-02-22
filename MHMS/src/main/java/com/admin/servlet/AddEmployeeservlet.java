package com.admin.servlet;

import java.io.IOException;

import com.db.DBConnect;
import com.emtity.AddEmployee;

import comm.Dao.AddEmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddEmployee")
public class AddEmployeeservlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	try {
		
		String name = req.getParameter("ename");
		String Age = req.getParameter("age");
		String Dob = req.getParameter("dob");
		String Pnumber = req.getParameter("pnumber");
		String salary = req.getParameter("salary");
		String email = req.getParameter("em");
		String Adnumber = req.getParameter("Anumber");
		
		AddEmployee E = new AddEmployee(name, Age, Dob, Pnumber, salary, email, Adnumber);
		
		AddEmployeeDao dao = new AddEmployeeDao(DBConnect.getconn());
		
		HttpSession session = req.getSession();
		
		
		if (dao.inserEmployee(E)) {
			
			session.setAttribute("succMsg", "Employee Addes Sucessfully..");
			resp.sendRedirect("Admin/AddAllEmployee.jsp");
			
		}else {
			

			session.setAttribute("errorMsg", "Employee not Addes Sucessfully..");
			resp.sendRedirect("Admin/AddAllEmployee.jsp");
		}
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}	
	
	}
}
