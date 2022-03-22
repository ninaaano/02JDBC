package jdbc.test;
import java.sql.*;

public class Example04 {
	//main method
	public static void main(String[] args) throws Exception{
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dirver="oracle.jdbc.driver.OracleDriver";
		
		Class.forName(dirver);
		
		Connection con=DriverManager.getConnection(url,"scott","tiger");
		
		Statement stmt=con.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT*FROM member");
		
		while(rs.next()) {
			int no = rs.getInt("NO");
			String id=rs.getString("ID");
			String pwd=rs.getString("pwd");
			System.out.println("회원정보=> 번호: "+no+"  id:"+id+"   pwd:"+pwd);
		}
		
		rs.close();
		con.close();
		stmt.close();
	}
}
