package comm.Dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emtity.Appointment;
import com.emtity.Doctor;

public class AppointmentDao {

	private Connection conn;

	public AppointmentDao(Connection conn) {
		super();
		this.conn = conn;
	}

public boolean addAppointment(Appointment ap) {
		
		boolean f = false;
		
		
		try {
			
//			
//			PreparedStatement ps = conn.prepareStatement("INSERT INTO appointmentt(name,gender,age,appoinDate,AadharNumber,PhNo,diseases,doctorId,address)VALUES(?,?,?,?,?,?,?,?,?)");
//			ps.setString(1, ap.getname());
//			ps.setString(2, ap.getGender());
//			ps.setString(3, ap.getAge());
//			ps.setString(4, ap.getAppoinDate());
//			ps.setString(5, ap.getAadharNumber());
//			ps.setString(6, ap.getPhNo());
//			ps.setString(7, ap.getDiseases());
//			ps.setString(8, ap.getDoctorId());
//			ps.setString(9, ap.getAddress());
//			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO appointment(userId,fullName,gender,age,appoinDate,AadharNumber,PhNo,diseases,doctorId,address,status)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, ap.getUserId());
			ps.setString(2, ap.getFullname());
			ps.setString(3, ap.getGender());
			ps.setString(4, ap.getAge());
			ps.setString(5, ap.getAppoinDate());
			ps.setString(6, ap.getAadharNumber());
			ps.setString(7, ap.getPhNo());
			ps.setString(8, ap.getDiseases());
			ps.setInt(9, ap.getDoctorId());
			ps.setString(10, ap.getAddress());
			ps.setString(11,ap.getStatus());
		
			
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


public List<Appointment> getPatient(int userid){
	
	List<Appointment> list = new ArrayList<Appointment>();
	Appointment ap=null;
	
	try {
		
//		String sql = "select *from doctor order by id desc";
		PreparedStatement ps=conn.prepareStatement("select *from appointment order by id desc");
		//ps.setInt(1,userId);
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			
			ap=new Appointment();
			ap.setId(rs.getInt(1));
			ap.setUserId(rs.getInt(2));
			ap.setFullname(rs.getString(3));
			ap.setGender(rs.getString(4));
			ap.setAge(rs.getString(5));
			ap.setAppoinDate(rs.getString(6));
			ap.setAadharNumber(rs.getString(7));
			ap.setPhNo(rs.getString(8));
			ap.setDiseases(rs.getString(9));
			ap.setDoctorId(rs.getInt(10));
			ap.setAddress(rs.getString(11));
			ap.setStatus(rs.getString(12));
			list.add(ap);
			
			
			
			
			
//			ps=new Appointment();
//			ps.setId(rs.getInt(1));
//			//ps.setname(rs.getString(2));
//			ps.setAge(rs.getString(3));
//			ps.setGender(rs.getString(4));
//			ps.setAppoinDate(rs.getString(5));
//			ps.setAadharNumber(rs.getString(6));
//			ps.setPhNo(rs.getString(7));
//			ps.setDiseases(rs.getString(8));
//			//ps.setDoctorId(rs.getString(9));
//			ps.setAddress(rs.getString(10));
//			list.add(ps);
//	
//			d=new Doctor();
//			d.setId(rs.getInt(1));
//			d.setFullName(rs.getString(2));
//			d.setDob(rs.getString(3));
//			d.setQualification(rs.getString(4));
//			d.setSpecialist(rs.getString(5));
//			d.setEmail(rs.getString(6));
//			d.setMobNO(rs.getString(7));
//			d.setPassword(rs.getString(8));
//			list.add(d);
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	
	return list;
	
}

	

public List<Appointment> getallAppointmentsbyDoctorLoing(int doctorId){
	
	List<Appointment> list = new ArrayList<Appointment>();
	Appointment ap=null;
	
	try {
		
//		String sql = "select *from doctor order by id desc";
		PreparedStatement ps=conn.prepareStatement("select *from appointment where doctorId=? ");
		ps.setInt(1,doctorId);
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			
			ap=new Appointment();
			ap.setId(rs.getInt(1));
			ap.setUserId(rs.getInt(2));
			ap.setFullname(rs.getString(3));
			ap.setGender(rs.getString(4));
			ap.setAge(rs.getString(5));
			ap.setAppoinDate(rs.getString(6));
			ap.setAadharNumber(rs.getString(7));
			ap.setPhNo(rs.getString(8));
			ap.setDiseases(rs.getString(9));
			ap.setDoctorId(rs.getInt(10));
			ap.setAddress(rs.getString(11));
			ap.setStatus(rs.getString(12));
			list.add(ap);
			
			
			
			
			
//			ps=new Appointment();
//			ps.setId(rs.getInt(1));
//			//ps.setname(rs.getString(2));
//			ps.setAge(rs.getString(3));
//			ps.setGender(rs.getString(4));
//			ps.setAppoinDate(rs.getString(5));
//			ps.setAadharNumber(rs.getString(6));
//			ps.setPhNo(rs.getString(7));
//			ps.setDiseases(rs.getString(8));
//			//ps.setDoctorId(rs.getString(9));
//			ps.setAddress(rs.getString(10));
//			list.add(ps);
//	
//			d=new Doctor();
//			d.setId(rs.getInt(1));
//			d.setFullName(rs.getString(2));
//			d.setDob(rs.getString(3));
//			d.setQualification(rs.getString(4));
//			d.setSpecialist(rs.getString(5));
//			d.setEmail(rs.getString(6));
//			d.setMobNO(rs.getString(7));
//			d.setPassword(rs.getString(8));
//			list.add(d);
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	
	return list;
	
}

}
