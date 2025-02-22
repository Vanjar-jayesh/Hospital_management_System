package com.admin.servlet;

import java.io.IOException;

import com.db.DBConnect;
import com.emtity.AddDepartment;

import comm.Dao.AddDepartmentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddDepartment")
public class AddDepartmentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			try {
				
				String dName=req.getParameter("dname");
				String pNumber=req.getParameter("number");
				
			
				AddDepartment D = new AddDepartment(dName, pNumber);
				AddDepartmentDao dao = new AddDepartmentDao(DBConnect.getconn());
				
				
				HttpSession session = req.getSession();
				
				if (dao.insertdepartment(D)) {
					
					session.setAttribute("succMsg", "Department Addes Sucessfully..");
					resp.sendRedirect("Admin/AddDepartment.jsp");
					
				}else {
					

					session.setAttribute("errorMsg", "Department not Addes Sucessfully..");
					resp.sendRedirect("Admin/AddDepartment.jsp");
				}
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
	}
}
