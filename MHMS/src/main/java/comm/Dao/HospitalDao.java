package comm.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.emtity.Hospital;
import com.emtity.Recepation;

public class HospitalDao {
	private Connection conn;

	public HospitalDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean HospitalsinUp(Hospital H) {
		boolean f = false;
				
		try {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO hospital(UserName,password)VALUES(?,?)");
			
			ps.setString(1, H.getUserName());
			ps.setString(2, H.getPassword());
		
			
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
	
	
	public  Hospital login(String UserName,String psw) {
		Hospital d = null;
		
		
		
		try {
			
			PreparedStatement ps=conn.prepareStatement("select *from hospital where UserName=? and password=?");
			ps.setString(1, UserName);
			ps.setString(2, psw);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				d= new Hospital();
				d.setId(rs.getInt(1));
				d.setUserName(rs.getString(2));
				d.setPassword(rs.getString(3));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}

}
