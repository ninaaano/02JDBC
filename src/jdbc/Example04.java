package jdbc;

import java.sql.*;

public class Example04 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//		String user ="scott";
//		String pwd = "tiger";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"scott","tiger");
		
		//Statement stmt = con.createStatement();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM member");
		ResultSet rs = pstmt.executeQuery();
		//ResultSet rs = pstmt.executeQuery("SELECT * FROM member"); 

		//3�ܰ� ��� Ȯ��
		while(rs.next()){  
	
		int no = rs.getInt("no");
		String id = rs.getString("id");
		String pwd = rs.getString("pwd");
		
		System.out.println("ȸ������ => ��ȣ : " + no + ",id : "+ id + ",pwd : "+pwd);
		
		}

		//������ ��ü�� close�Ѵ�.
		rs.close();
		pstmt.close();
		con.close();

	}//end of main

}//end of class

