package jdbc.test;
import java.sql.*;

import java.util.Scanner;
public class Example02 {
	//main method
	public static void main(String[] args) throws Exception{		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver ="oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url,"scott","tiger");
		
//		Statement stmt = con.createStatement();
		
		Scanner stdIn =new Scanner(System.in);
		System.out.println("no입력");
		int no=stdIn.nextInt();
		System.out.println("id입력");
		String id= stdIn.next();
		System.out.println("pwd입력");
		String pwd=stdIn.next();
		
		//DML:insert
//		String sql1="INSERT INTO member values('"+no+"','"+id+"','"+pwd+"')";
		//dml 전송
//		int i= stmt.executeUpdate(sql1);
//		System.out.println("1번 insert유무"+i+"개의 형이 만들어졌습니다.");
//		i = stmt.executeUpdate(sql2);
//		System.out.println("2번 insert유무:"+i+"개의 형이 만들어졌습니다.");
//		
//		i= stmt.executeUpdate(sql3);
//		System.out.println("3번 insert유무:"+i+"개의 형이 만들어졌습니다.");
//		

		
		PreparedStatement pstmt=con.prepareStatement("insert into member values(?,?,?)");
		pstmt.setInt(1, no);
		pstmt.setString(2, id);
		pstmt.setString(3, pwd);
		int confirm = pstmt.executeUpdate();
		/////////////////////////////////////////
		
		if(confirm==1) {
			System.out.println("member Table data insert 완료");
		}else {
			System.out.println("member Table Data Insert 실패");
		}
				
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
}
