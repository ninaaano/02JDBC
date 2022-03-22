package work;

import java.sql.*;
import java.util.*;

public class Prob5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("부서의 아이디를 입력하세요..");
			System.exit(1);
		}
		
		String dept_id = args[0];
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "hr";
			String password = "hr";
			
			con = DriverManager.getConnection(url,"hr","hr");
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("SELECT\r\n"
					+ "e.employee_id ,\r\n"
					+ "d.department_name,\r\n"
					+ "e.salary,\r\n"
					+ "vt.salary\r\n"
					+ "FROM employees e, departments d, (\r\n"
					+ "SELECT\r\n"
					+ "AVG(salary) salary,\r\n"
					+ "department_id\r\n"
					+ "FROM employees\r\n"
					+ "GROUP BY department_id) vt\r\n"
					+ "WHERE e.department_id = d.department_id\r\n"
					+ "AND vt.department_id = e.department_id\r\n"
					+ "AND d.department_id = '"+dept_id+"'");
			 
			
			while(rs.next()) {
				int employeeId = rs.getInt(1);
				String departmentName = rs.getString(2);
				int salary = rs.getInt(3);
				int avgSal = rs.getInt(4);
				System.out.println(employeeId+" "+departmentName+" "+salary+" "+avgSal);
			}
			rs.close();
			stmt.close();
			con.close();
			
		}catch(SQLException e) {
			System.out.println("\n==> JDBC절차중 Exception 발생:"+e.getErrorCode());
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		}

	}

