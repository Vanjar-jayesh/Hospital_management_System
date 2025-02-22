package comm.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emtity.AddAmbulance;
import com.emtity.Doctor;

public class AddAmbulanceDao {

	private Connection conn;

	public AddAmbulanceDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	public boolean insertAmbulance( AddAmbulance A) {
		boolean f= false;
		
		
		try {
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO ambulance(carnumber,Available,address)VALUES(?,?,?)");
			ps.setString(1, A.getCarnumber());
			ps.setString(2, A.getAvailable());
			ps.setString(3, A.getAddress());
			
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
	
	public  int  countAmbulance() {
		int i =0;
		
		try {
			
			PreparedStatement ps=conn.prepareStatement("select *from ambulance");
			
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			i++;
			
		}
		
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return i;
	}
	
public List<AddAmbulance> getAllAmbulance(){
		
		List<AddAmbulance> list = new ArrayList<AddAmbulance>();
		AddAmbulance d=null;
		
		try {
			
//			String sql = "select *from doctor order by id desc";
			PreparedStatement ps=conn.prepareStatement("select *from ambulance order by id desc");
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				d = new AddAmbulance();
				d.setId(rs.getInt(1));
				d.setCarnumber(rs.getString(2));
				d.setAvailable(rs.getString(3));
				d.setAddress(rs.getString(4));
				list.add(d);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}

}
