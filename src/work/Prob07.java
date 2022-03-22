package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prob07 {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		printEmployeeList("lon","resource");
	}
	
	private static void printEmployeeList(String cityName, String deptName) throws Exception {
		String dburl="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection con =DriverManager.getConnection(dburl,"hr","hr");
		Statement stmt = con.createStatement();	
		ResultSet rs = stmt.executeQuery("SELECT\r\n"
				+ "l.city,\r\n"
				+ "d.department_name,\r\n"
				+ "e.first_name,\r\n"
				+ "e.salary\r\n"
				+ "FROM employees e, departments d, locations l\r\n"
				+ "WHERE e.department_id = d.department_id\r\n"
				+ "AND d.location_id = l.location_id\r\n"
				+ "AND upper(l.city) LIKE upper('%"+cityName+"%')\r\n"
				+ "AND upper(d.department_name) LIKE upper('%"+deptName+"%')");
		
		while(rs.next()) {
			String city = rs.getString("city");
			String dptName = rs.getString("department_name");
			String fstName = rs.getString("first_name");
			int salary = rs.getInt("salary");
			System.out.println(city+" "+dptName+" "+fstName+" "+salary);
		}
		rs.close();
		stmt.close();
		con.close();
		
	}

}
