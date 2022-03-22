package jdbc.test;
import java.sql.*;
public class Example01 {
	//main method
	public static void main(String[] args) {
		//JDBC절차에 필요 인스턴스 및 정보 선언
		Connection con=null;
		Statement stmt =null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		try {
			//1.login
			//jdbc연결에 맞는 드라이버 설정 작업을 진행한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1.Driver loading OK");
			
			con = DriverManager.getConnection(url,"scott","tiger");
			System.out.println("2.connection 인스턴스 생성 완료");
			
			//statement
			//DB와의 연결(이하 세션)을 통해서 쿼리를 수행할 준비를 한다.
			stmt = con.createStatement();
			System.out.println("3.statement객체 생성 완료");
			
			//Create Query
//			String createSql=
//					"CREATE TABLE member"
//					+ "(no MUMBER,"
//					+ "id VARCHAR2(10),"
//					+ "pwd VACHAR2(10))";
			String createSql =
					"Create TABLE member"+
			"(no	Number,"+
			"id VARCHAR2(10),"+
			"pwd VARCHAR2(10))";
			
			System.out.println("::query 전송결과:"+stmt.executeUpdate(createSql));
			System.out.println("4.query 전송완료");
		}catch (ClassNotFoundException e) {
			System.out.println("\n ==>Driver loading시 exception발생");
			e.printStackTrace();
			// TODO: handle exception
		}catch (SQLException e) {
			System.out.println("\n==>jdbc절차 중 exception 발생:"+e.getErrorCode());
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					con.close();
				if(stmt!=null)
					stmt.close();
			}catch (SQLException e) {
				System.out.println("\n==> jdbc절차 중 exception발생:"+e.getErrorCode());
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
	}

}
