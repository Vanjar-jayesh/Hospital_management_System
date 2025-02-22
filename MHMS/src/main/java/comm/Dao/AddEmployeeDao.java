package comm.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emtity.AddAmbulance;
import com.emtity.AddEmployee;

public class AddEmployeeDao {

	private Connection conn;

	public AddEmployeeDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	public boolean inserEmployee(AddEmployee E) {
		boolean f = false;
		
		try {
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO employee(name,age,dob,Pnumber,salary,email,Adnumber)VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, E.getName());
			ps.setString(2, E.getAge());
			ps.setString(3, E.getDob());
			ps.setString(4, E.getPNumber());
			ps.setString(5, E.getSalary());
			ps.setString(6, E.getEmail());
			ps.setString(7, E.getAdnumber());
			
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
	
	public  int  countEmployee() {
		int i =0;
		
		try {
			
			PreparedStatement ps=conn.prepareStatement("select *from employee");
			
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
	
public List<AddEmployee> getAllEmployee(){
		
		List<AddEmployee> list = new ArrayList<AddEmployee>();
		AddEmployee d=null;
		
		try {
			
//			String sql = "select *from doctor order by id desc";
			PreparedStatement ps=conn.prepareStatement("select *from employee order by id desc");
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				d = new AddEmployee();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setAge(rs.getString(3));
				d.setDob(rs.getString(4));
				d.setPNumber(rs.getString(5));
				d.setSalary(rs.getString(6));
				d.setEmail(rs.getString(7));
				d.setAdnumber(rs.getString(8));
		
				list.add(d);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}

}
