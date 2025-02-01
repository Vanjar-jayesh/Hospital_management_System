package com.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emtity.Specalist;



//@WebServlet("/AddSpecialist")
public class SpecialistDao {
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String spec=req.getParameter("specName");
//
//		PrintWriter out = resp.getWriter();
//		
//		
//		try {
//			
//			UserDao conn = new UserDao(DBConnect.getconn());
//			
//			PreparedStatement ps = ((Connection) conn).prepareStatement("INSERT INTO specialist(spec_name)VALUES(?)");
//     		ps.setString(1, spec);
//			
//     		
//	      int count =  ps.executeUpdate();
//			
////			HttpSession Session = ((Object) req).getSeesion();
//			if (count >0) {
//				
//				resp.setContentType("text/html");
//				out.print("<h3 Style='color:green'> user registered successfully </h3>" );
//				
//				RequestDispatcher rd = req.getRequestDispatcher("Admin/index.jsp");
//				rd.include(req, resp);
//				
//			}else {
//				resp.setContentType("text/html");
//				out.print("<h3 Style='color:red'> user  not registered successfully </h3>" );
//				
//				RequestDispatcher rd = req.getRequestDispatcher("admin_Login.jsp");
//				rd.include(req, resp);
//				
//				
//				
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//	}

	private Connection conn;

	public SpecialistDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	public boolean addSpecialist(String spec) {
		boolean f = false;
		
		try {
			
			//String sql="insert into specialist(spec_name)values(?)";
			
//			PreparedStatement ps = conn.prepareStatement("INSERT INTO specialist(spec_name)VALUES(?)");
//			ps.setString(1, spec);
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO specialist(spec_name)VALUES(?)");
			ps.setString(1, spec);
			
			int i = ps.executeUpdate();
			
			if (i==1) {
				f = true;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return f;
	}
	
	
	public List<Specalist> getAllSpecilist(){
		
		
		List<Specalist> list = new ArrayList<Specalist>();
		Specalist s= null;
		
		try {
			
			String sql = "select *from specialist ";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			
			ResultSet rs=ps.executeQuery();
			
		while (rs.next()) {
		
			s=new Specalist();
			s.setId(rs.getInt(1));
			s.setSpecialistName(rs.getString(2));
			list.add(s);
		}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}
