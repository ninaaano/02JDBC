package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateJDBC02 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con =null;
		Statement stmt =null;
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. driver loading OK");
		
			con = DriverManager.getConnection(url,"scott","tiger");
			System.out.println("2. connection 인스턴스 생성 완료");
		
			stmt=con.createStatement();
			System.out.println("3. statement객체 생성완료");
		
			String createSql = 
					"CREATE TABLE firstJDBC"
			+		"(no number(3),"
			+ 		"name varchar2(20),"
			+ 		"email varchar2(30),"
			+ 		"address varchar2(50))";
			
			System.out.println(":: QUERY 전송 결과"+stmt.executeUpdate(createSql) );
			System.out.println("4.query 전송 완료");
			
			}catch(ClassNotFoundException e){
				System.out.println("\n==> Driver Loading 시 Exception 발생\n");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("\n==> JDBC 절차 중 Exception 발생 :"+e.getErrorCode());
				e.printStackTrace();
			} catch(Exception e){
				System.out.println("\n Exception 발생"+e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if(stmt !=null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					System.out.println("\n==> JDBC 절차 중 Exception 발생 :"+e.getErrorCode());
					e.printStackTrace();
				}
			}//finally
	
	}//main
}//class
