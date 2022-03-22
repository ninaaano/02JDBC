package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Example02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url,"scott","tiger");
		
		//Statement stmt = con.createStatement();
		
//		int no = Integer.parseInt(args[0]);
//		String id = args[1];
//		String pwd = args[2];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("no �Է� : ");
		int no = sc.nextInt();
		
		System.out.println("id �Է� : ");
		String id = sc.next();
		
		System.out.println("pwd �Է� : ");
		String pwd = sc.next();

//		args[0] : member TABLE�� no 
//		args[1] : member TABLE�� id 
//		args[2] : member TABLE�� pwd 
		

//		String sql1 = "INSERT INTO member VALUES(1,'"+no+"','no')";
//		String sql2 = "INSERT INTO member VALUES(2,'"+id+"','id')";
//		String sql3 = "INSERT INTO member VALUES(3,'"+pwd+"','pwd')";
//		
		PreparedStatement pstmt = con.prepareStatement("insert into member values(?,?,?)");
		
		pstmt.setInt(1, no);
		pstmt.setString(2, id);
		pstmt.setString(3, pwd);
		int confirm = pstmt.executeUpdate();
		
		if(confirm == 1) {
			System.out.println("number table data insert �Ϸ�");
		}else {
			System.out.println("number table data insert ����");
		}
		
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
	
	
//		int i = stmt.executeUpdate(sql1);
//		
//		i = stmt.executeUpdate(sql2);
//		
//		i = stmt.executeUpdate(sql3);
//		System.out.println("number TABLE data INSERT �Ϸ�");
//		
//		if(stmt != null) {
//			stmt.close();
//		}
//		if(con != null) {
//			con.close();
//		}
		}
	}





