package work;

import java.sql.*;
public class EmpStatistics {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		int maxSalary = 10000;
		new EmpStatistics().printStatistics(maxSalary);
		
		maxSalary = 15000;
		new EmpStatistics().printStatistics(maxSalary);
		

	}

	public void printStatistics(int maxSalary) throws SQLException{
		// TODO Auto-generated method stub
		
		System.out.println("==============================");
		System.out.println("Max Salary : "+maxSalary);
		System.out.println("==============================");
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection con = DriverManager.getConnection(url,"hr","hr");
				
		//String query = "select * from employees (?)";
		String query = "select\r\n"
				+ "j.job_title,\r\n"
				+ "AVG(e.salary)\r\n"
				+ "FROM employees e, jobs j\r\n"
				+ "WHERE e.job_id = j.job_id AND\r\n"
				+ "e.salary >= ?\r\n"
				+ "GROUP BY j.job_title\r\n"
				+ "ORDER BY AVG(e.salary) DESC";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		
		
		pstmt.setInt(1, maxSalary);
		//pstmt.setString(2, "apple");
		
		ResultSet rs = pstmt.executeQuery();
		
		// Select a,b,c from A;
		while(rs.next()) {
			//int a1 = rs.get(1);
			String b1 = rs.getString(1);
			int c1 = rs.getInt(2);
			System.out.println("["+b1+"]"+c1);
		}
		con.close();
		rs.close();
		pstmt.close();

	}

}
