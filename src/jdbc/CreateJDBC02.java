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
			System.out.println("2. connection �ν��Ͻ� ���� �Ϸ�");
		
			stmt=con.createStatement();
			System.out.println("3. statement��ü �����Ϸ�");
		
			String createSql = 
					"CREATE TABLE firstJDBC"
			+		"(no number(3),"
			+ 		"name varchar2(20),"
			+ 		"email varchar2(30),"
			+ 		"address varchar2(50))";
			
			System.out.println(":: QUERY ���� ���"+stmt.executeUpdate(createSql) );
			System.out.println("4.query ���� �Ϸ�");
			
			}catch(ClassNotFoundException e){
				System.out.println("\n==> Driver Loading �� Exception �߻�\n");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("\n==> JDBC ���� �� Exception �߻� :"+e.getErrorCode());
				e.printStackTrace();
			} catch(Exception e){
				System.out.println("\n Exception �߻�"+e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if(stmt !=null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					System.out.println("\n==> JDBC ���� �� Exception �߻� :"+e.getErrorCode());
					e.printStackTrace();
				}
			}//finally
	
	}//main
}//class
