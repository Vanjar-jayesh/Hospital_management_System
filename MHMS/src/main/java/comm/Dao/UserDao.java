package comm.Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.emtity.User;

public class UserDao {

	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean rigister(User u) {
		boolean f = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO user(name,email,password) VALUES(?,?,?)");
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			
			int i =  ps.executeUpdate();
			
			if (i==1) {
				f = true;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		return f;
	}
	
	
	public User login(String em,String psw) {
		
		
		User u = null;
		
		
		try {
			
			
			//String sql = "select * from user where email=? and password=?";
			PreparedStatement ps1=conn.prepareStatement("select * from user where email=? and password=?");
			ps1.setString(1, em);
			ps1.setString(2, psw);
			
			
			ResultSet rs=ps1.executeQuery();
			
			while (rs.next()) {
				
				u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getNString(3));
				u.setPassword(rs.getString(4));
				
				
				
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return u;
	}
	
}
