package comm.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emtity.AddAmbulance;
import com.emtity.AddPatient;
import com.emtity.Doctor;
import com.emtity.Room;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare.Builder;

public class AddpatientDao {

	private Connection conn;

	public AddpatientDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	
	
	public boolean addpateints(AddPatient P) {
		boolean f = false;
		
		
		
		try {
					
					PreparedStatement ps=conn.prepareStatement("INSERT INTO addpatientss(name,dob,gender,diseases,doctorid,room,email,mobno,adnumber,address)VALUES(?,?,?,?,?,?,?,?,?,?)");
					
			
//					
					
					ps.setString(1, P.getName());
					ps.setString(2, P.getDob());
					ps.setString(3, P.getGender());
					ps.setString(4, P.getDiseases());
					ps.setInt(5, P.getDoctorId());
					ps.setString(6, P.getRoom());
					ps.setString(7, P.getEmail());
					ps.setString(8, P.getMobno());
					ps.setString(9, P.getAdnumber());
					ps.setString(10, P.getAddress());
					
					
				
					
				
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
	
	public  boolean inserpateint(AddPatient P){
		boolean f = false;
		
	
try {
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO addpatient(name,dob,gender,diseases,doctor,room,email,mobno,adnumber,address)VALUES(?,?,?,?,?,?,?,?,?,?)");
			
	
//			
			
			ps.setString(1, P.getName());
			ps.setString(2, P.getDob());
			ps.setString(3, P.getGender());
			ps.setString(4, P.getDiseases());
			ps.setString(5, P.getDoctor());
			ps.setString(6, P.getRoom());
			ps.setString(7, P.getEmail());
			ps.setString(8, P.getMobno());
			ps.setString(9, P.getAdnumber());
			ps.setString(10, P.getAddress());
			
			
		
			
		
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
	
	
public List<AddPatient> getAddPatient(){
		
		List<AddPatient> list = new ArrayList<AddPatient>();
		AddPatient d=null;
		
		try {
			
//			String sql = "select *from doctor order by id desc";
			PreparedStatement ps=conn.prepareStatement("select *from addpatientss order by id desc");
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				d = new AddPatient();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setGender(rs.getString(4));
				d.setDiseases(rs. getString(5));
//				d.setDoctor(rs.getString(6));
				d.setDoctorId(rs.getInt(6));
				d.setRoom(rs.getString(7));
				d.setEmail(rs.getString(8));
				d.setMobno(rs.getString(9));
				d.setAdnumber(rs.getString(10));
				d.setAddress(rs.getString(11));	
				list.add(d);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}


}
