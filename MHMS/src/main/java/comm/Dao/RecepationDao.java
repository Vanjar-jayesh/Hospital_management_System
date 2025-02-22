package comm.Dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.emtity.Doctor;
import com.emtity.Recepation;

public class RecepationDao {
	private Connection conn;

	public RecepationDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
 public boolean registerRecepation(Recepation p) {
		
		boolean f = false;
		
		
		try {
			
					
			PreparedStatement ps = conn.prepareStatement("INSERT INTO recepation(UserName,password)VALUES(?,?)");
			ps.setString(1, p.getUserName());
			ps.setString(2, p.getPassword());
		
			
		int i = ps.executeUpdate();
		
		if (i == 1) {
			
			return true;
		}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return f;
	}

 
//
//	public  Recepation loginRecepation(String userName,String Password) {
//		Recepation R = null;
//		
//		
//		
//		try {
//			
//			PreparedStatement ps=conn.prepareStatement("select *from reception where UserName=? and password=?");
//			ps.setString(1, userName);
//			ps.setString(2, Password);
//			
//			ResultSet rs=ps.executeQuery();
//			while (rs.next()) {
//				R= new Recepation();
//				R.setUserName(rs.getString(1));
//				R.setPassword(rs.getString(2));
//				
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return R;
//	}
 
// public Recepation logi(String usern,String psw) {
//	 
//	 Recepation  r = null;
//	 
//	 try {
//		 
//		 
//		 PreparedStatement ps=conn.prepareStatement("select *from recepation where UserName=? and Password=?");
//		 ps.setString(1, usern);
//		 ps.setString(2, psw);
//		 
//		 ResultSet rs = ps.executeQuery();
//		 
//		 while (rs.next()) {
//			r = new Recepation();
//			r.setId(rs.getInt(1));
//			r.setUserName(rs.getString(2));
//			r.setPassword(rs.getString(3));
//			
//		}
//		
//	} catch (Exception e) {
//		// TODO: handle exception
//		e.printStackTrace();
//	}
//			 
//			
//   return r;
//	
//}


	public  Recepation login(String UserName,String psw) {
		Recepation d = null;
		
		
		
		try {
			
			PreparedStatement ps=conn.prepareStatement("select *from recepation where UserName=? and password=?");
			ps.setString(1, UserName);
			ps.setString(2, psw);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				d=new Recepation();
				d.setId(rs.getInt(1));
				d.setUserName(rs.getString(2));
				//d.setFullName(rs.getString(2));
				//d.setDob(rs.getString(3));
				//d.setQualification(rs.getString(4));
				//d.setSpecialist(rs.getString(5));
				//d.setEmail(rs.getString(6));
				//d.setMobNO(rs.getString(7));
				d.setPassword(rs.getString(3));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}

	
}
