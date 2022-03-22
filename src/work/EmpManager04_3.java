package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpManager04_3 {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws SQLException{
		
		String[] jobs = {"Accountant","Stock Clerk"};
		new EmpManager04_3().printEmployee(jobs);
		
	}
	public void printEmployee(String jobs[]) throws SQLException {
		try {
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection con =DriverManager.getConnection(url,"hr","hr");
		Statement stmt = con.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT\r\n"
				+ "e.employee_id,\r\n"
				+ "e.first_name,\r\n"
				+ "e.salary\r\n"
				+ "FROM employees e, jobs j\r\n"
				+ "WHERE e.job_id = j.job_id \r\n"
				+ "AND j.job_title IN ('Stock Clerk', 'Accountant')");
		 
		while(rs.next()) {
			int employeeId = rs.getInt("employee_id");
			String firstName = rs.getString("first_name");
			int salary = rs.getInt("salary");
			System.out.println(employeeId+" "+firstName+" "+salary);
		}
		rs.close();
		stmt.close();
		con.close();
		
	}catch(SQLException e) {
		System.out.println("\n==> JDBC절차중 Exception 발생:"+e.getErrorCode());
		e.printStackTrace();
	}
	}
	
}
