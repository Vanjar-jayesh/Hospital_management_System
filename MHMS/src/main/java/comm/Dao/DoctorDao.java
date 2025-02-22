package comm.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emtity.Doctor;

public class DoctorDao {

	private Connection conn;

	public DoctorDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	public boolean registerDoctor(Doctor d) {
		
		boolean f = false;
		
		
		try {
			
					
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Doctor(fullName,dob,qualification,specialist,email,mobNO,password)VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNO());
			ps.setString(7, d.getPassword());
			
			
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
	
	
	public List<Doctor> getAllDoctor(){
		
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d=null;
		
		try {
			
//			String sql = "select *from doctor order by id desc";
			PreparedStatement ps=conn.prepareStatement("select *from doctor order by id desc");
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				
				d=new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNO(rs.getString(7));
				d.setPassword(rs.getString(8));
				list.add(d);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}
	
	
public Doctor getDoctorById(int id){
		
		
		Doctor d=null;
		
		try {
			
//			String sql = "select *from doctor order by id desc";
			PreparedStatement ps=conn.prepareStatement("select *from doctor where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				
				d=new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNO(rs.getString(7));
				d.setPassword(rs.getString(8));
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return d;
		
	}


public boolean UpDateDoctor(Doctor d) {
	
	boolean f = false;
	
	
	try {
		
				
		PreparedStatement ps = conn.prepareStatement("update Doctor set fullName=?,dob=?,qualification=?,specialist=?,email=?,mobNO=?,password=? where id=?");
		ps.setString(1, d.getFullName());
		ps.setString(2, d.getDob());
		ps.setString(3, d.getQualification());
		ps.setString(4, d.getSpecialist());
		ps.setString(5, d.getEmail());
		ps.setString(6, d.getMobNO());
		ps.setString(7, d.getPassword());
		ps.setInt(8, d.getId());
		
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


public  boolean deleteDoctor(int id) {
	
	boolean f = false;
	
	try {
		
		PreparedStatement ps = conn.prepareStatement("delete from Doctor where id=?");
		ps.setInt(1, id);
		
		int i=ps.executeUpdate();
		if (i==1) {
			f = true;
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	
	
	
	return f;
   }

	
	public  Doctor login(String email,String psw) {
		Doctor d = null;
		
		
		
		try {
			
			PreparedStatement ps=conn.prepareStatement("select *from Doctor where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, psw);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				d=new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNO(rs.getString(7));
				d.setPassword(rs.getString(8));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}

}
