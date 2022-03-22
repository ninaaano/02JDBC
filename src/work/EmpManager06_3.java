package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpManager06_3 {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException{
		new EmpManager06_3().printEmployee("South San Francisco",7000,10000);
	}
	
	public void printEmployee(String city,int lo, int hi) throws SQLException{
		String dburl="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection con =DriverManager.getConnection(dburl,"hr","hr");
		Statement stmt = con.createStatement();	
		ResultSet rs = stmt.executeQuery("SELECT\r\n"
				+ "e.last_name,\r\n"
				+ "d.department_name\r\n"
				+ "From employees e, departments d, locations l\r\n"
				+ "WHERE e.department_id = d.department_id\r\n"
				+ "AND d.location_id = l.location_id\r\n"
				+ "AND l.city = '"+city+"'\r\n"
				+ "AND e.salary Between '"+lo+"' AND '"+hi+"'");
		
		while(rs.next()) {
			String lastName = rs.getString("last_name");
			String dptName = rs.getString("department_name");
			System.out.println(lastName+" "+dptName);
		}
		rs.close();
		stmt.close();
		con.close();
		
	}
		
}
