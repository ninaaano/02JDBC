package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Example03 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);		
		Connection con = DriverManager.getConnection(url,"scott","tiger");
		
		Statement stmt = con.createStatement();
		//PreparedStatement pstmt = con.prepareStatement("delete member values(?,?,?)");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 id 입력 : ");
		String id = sc.next();
		
		//DML : DELETE
		String sql = "DELETE FROM MEMBER WHERE id = '"+id+"'";
		
		//excuteUpdate() : DELETE전송
		int i = stmt.executeUpdate(sql);
		// int confirm = pstmt.executeUpdate();
		
		System.out.println("number TABLE RECORD DELETE 완료");
		
		if(stmt != null) {
			stmt.close();
		}
		if(con != null) {
			con.close();
		}
		//if(pstmt != null) pstmt.close();
		//if(con != null) con.close();
	}

}
	