package work;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class EmpManager {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException{
	
		new EmpManager().printEmployee("al",4000);
		
	}
	
	public void printEmployee(String name,int Salary) throws SQLException{

		try {
			String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
//			System.out.println("1.driver loading OK");
			
			Connection con =DriverManager.getConnection(url,"hr","hr");
//			System.out.println("2.connection 인스턴스 생성 완료");
			
			Statement stmt = con.createStatement();
//			System.out.println("3.Statement객체 생성 완료");
			
			ResultSet rs=stmt.executeQuery("SELECT\r\n"
					+ "employee_id,\r\n"
					+ "first_name,\r\n"
					+ "salary\r\n"
					+ "FROM employees\r\n"
					+ "WHERE salary >= 4000 AND upper(first_name) LIKE upper('%al%')");
			 
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
