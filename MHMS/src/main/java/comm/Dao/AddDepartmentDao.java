package comm.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emtity.AddDepartment;
import com.emtity.AddEmployee;

public class AddDepartmentDao {

	private Connection conn;

	public AddDepartmentDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	
	public boolean insertdepartment(AddDepartment D) {
		boolean f = false;
		
		try {
			
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO department(DName,Pnumber)VALUES(?,?)");
			ps.setString(1, D.getDName());
			ps.setString(2, D.getPnumber());
			
			int i = ps.executeUpdate();
			
			if (i==1) {
				return true;
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return f;
	}
	
	public  int  countdeparment() {
		int i =0;
		
		try {
			
			PreparedStatement ps=conn.prepareStatement("select *from department");
			
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


public List<AddDepartment> getAllDepartment(){
		
		List<AddDepartment> list = new ArrayList<AddDepartment>();
		AddDepartment d=null;
		
		try {
			
//			String sql = "select *from doctor order by id desc";
			PreparedStatement ps=conn.prepareStatement("select *from department order by id desc");
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				d = new AddDepartment();
				d.setId(rs.getInt(1));
				d.setDName(rs.getString(2));
				d.setPnumber(rs.getString(3));
				
				list.add(d);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}
}
