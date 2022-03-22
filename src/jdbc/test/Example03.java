package jdbc.test;
import java.sql.*;

import java.util.Scanner;
public class Example03 {
	//main method
	public static void main(String[] args) throws Exception{
		//jdbc절차에 필요 인스턴스 및 정보 선언
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,"scott","tiger");
		
//		Statement stmt=con.createStatement();
		
		Scanner stdIn=new Scanner(System.in);
		System.out.println("지우고싶은 no을 입력해 주세요:");
		int no=stdIn.nextInt();
//		String sql="delete from member where no=("+no+")"; 
//		
//		int i=stmt.executeUpdate(sql);
//		System.out.println("delete된 record의 수는:"+i+"행이 삭제되었습니다.");
		
//		if(stmt!=null)
//			stmt.close();
		
		PreparedStatement pstmt=con.prepareStatement("delete from member where no=(?)");
		pstmt.setInt(1, no);
		int confirm =pstmt.executeUpdate();
		if(confirm==1) {
			System.out.println("number table data delete 완료");
		}else {
			System.out.println("number table data delete 실패");
		}
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
}
