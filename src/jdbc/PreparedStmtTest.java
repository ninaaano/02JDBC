package jdbc;
import java.sql.*;
public class PreparedStmtTest {
	//main method
	public static void main(String[] args) throws Exception{
		//입력Data Validation check
		if(args.length!=3) {
			System.out.println("실행방법 java Example02[no값][id값][pwd값]");
			System.exit(0);
		}
		int no = Integer.parseInt(args[0]);
		String id = args[1];
		String pwd = args[2];
		
		String url ="jdbc:oracle:thin:@127.0.0.1521:xe";
		
		//1단계 :Connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"scott","tiger");
		
		//////////////////////////////////////////////////////
		//statement / PreparedState비교 이해
		//========statement 사용 ===========
		//Statement stmt = con.createStatement();
		//String createSql = "insert into member vcalues("+no+","+id+","+pwd+")";
		//int confirm = stmt.executeUpdate(createSql);
		
		//==============PreparedStatement 사용===============
		//PrepareStatement 인스턴스 생성시 sql구성
		PreparedStatement pstmt = con.prepareStatement("insert into member values(?,?,?)");
		
		//PreparedStatement method 사용 Data SET  (''불필요)
		pstmt.setInt(1,no);
		pstmt.setString(2, id);
		pstmt.setString(3, pwd);
		int confirm = pstmt.executeUpdate();
		///////////////////////////////////////////
		
		if(confirm ==1) {
			System.out.println("number TAble Data insert 완료");
		}else {
			System.out.println("number Table Data Insert 실패");
		}
		if(pstmt!=null) pstmt.close();
		if(con!=null) con.close();
	}//end of main

}//end of class
