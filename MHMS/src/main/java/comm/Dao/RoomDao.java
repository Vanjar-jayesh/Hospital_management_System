package comm.Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import com.emtity.AddDepartment;
import com.emtity.Doctor;
import com.emtity.Room;
import com.oracle.wls.shaded.org.apache.regexp.recompile;

public class RoomDao {

	private Connection conn;
	
	
	public RoomDao(Connection conn) {
		super();
		this.conn = conn;
	}


	public boolean insetRoom(Room R) {
		boolean f = false;
		
		try {
			
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO room(Type,capacity,Availablity)VALUES(?,?,?)");
			//ps.setInt(1, R.getId());
			ps.setString(1, R.getType());
			ps.setString(2, R.getCapacity());
			ps.setString(3,R.getAvailablity());
		
			
		int i = 	ps.executeUpdate();
		
		if (i == 1) {
			
			return true;
		}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return f;
	}
	
	public  int  countRoom() {
		int i =0;
		
		try {
			
			PreparedStatement ps=conn.prepareStatement("select *from room");
			
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
	

public List<Room> getAllRoom(){
		
		List<Room> list = new ArrayList<Room>();
		Room d=null;
		
		try {
			
//			String sql = "select *from doctor order by id desc";
			PreparedStatement ps=conn.prepareStatement("select *from room order by id desc");
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				d = new Room();
				d.setId(rs.getInt(1));
				d.setType(rs.getString(2));
				d.setCapacity(rs.getString(3));
				d.setAvailablity(rs.getString(4));
				
				list.add(d);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}




public boolean UpRoom(Room R ) {
	
	boolean f = false;

	
	try {
		
				
		PreparedStatement ps = conn.prepareStatement("Update room set Availablity='Occupied' where  Type=?");
//	    ps.setInt(1, R.getId());
//	    ps.setString(2, R.getType());
//	    ps.setString(3, R.getCapacity());
	    ps.setString(1, R.getAvailablity());
		int i = 	ps.executeUpdate();


		
		if (i == 1) {
			
			return true;
		}
	

		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	
	return f;
}


public  boolean UPdatRoom(Room R) {
	boolean f = false;
	
	try {
		
		PreparedStatement ps=conn.prepareStatement("select *from room order by id desc");
		ps.setInt(1, R.getId());
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			String capcity = rs.getString(R.getCapacity());
			
			int cl = 0;

		    try {
                cl= Integer.parseInt(capcity);
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
            
			if (cl ==2) {
				PreparedStatement ps1 = conn.prepareStatement("Update room set Availablity='Occupied' where  Type=?");
//			    ps.setInt(1, R.getId());
//			    ps.setString(2, R.getType());
//			    ps.setString(3, R.getCapacity());
			    ps1.setString(1, R.getAvailablity());
				int i = 	ps1.executeUpdate();

				
				if (i == 1) {
					
					return true;
				}
			
			}
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	
	
	return f;
}

}
