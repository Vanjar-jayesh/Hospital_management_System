package com.admin.servlet;

import java.io.IOException;

import com.db.DBConnect;
import com.emtity.Room;

import comm.Dao.RoomDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddRoom")
public class AddRoom extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		try {
			
			String type = req.getParameter("type");
			String capacity=req.getParameter("capacity");
			String availablity=req.getParameter("Avalibality");
			
			Room R = new Room(type, capacity, availablity);
			
			RoomDao dao = new RoomDao(DBConnect.getconn());
            HttpSession session = req.getSession();
			
			if (dao.insetRoom(R)) {
				
				session.setAttribute("succMsg", "Room Addes Sucessfully..");
				resp.sendRedirect("Admin/AddRoom.jsp");
				
			}else {
				

				session.setAttribute("errorMsg", "Room not Addes Sucessfully..");
				resp.sendRedirect("Admin/AddRoom.jsp");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
