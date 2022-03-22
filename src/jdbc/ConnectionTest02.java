package jdbc;
import java.sql.*;
//import java.util.*;
import java.util.Properties;

//==>아래의 import 주석 처리한 이유의 이해
//import oracle.jdbc.driver.*;
/*
 * filename : ConnectionTest02.java
 */
public class ConnectionTest02 {
	//main method
	public static void main(String[] args) throws Exception{
		//DB에 로그인 접속정보
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String pwd = "tiger";
		
		/*
		//==DMBS종속적인 아래의 부분을 주석 이유 이해===
		//1.단계 connection:login 과정
		//1.1.oracleDriver od = new Oracledriver();
		
		1.2 oracle에 접속 정보를 갖는 properties Instance생성
		Properties info = new Properties();
		info.put("user", user);
		info.put("password", pwd);
		
		//1.3 OracleDriver intance를 사용 Connection instance생성
		Connextion con = od.connect(url.info);
		===========================================*/
		
		//interface기반 Programming:java.sql.*이용 DBMS비종속적인 DB
		//1.단계: connection::login과정
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,user,pwd);
		
		//2단계 QUERY(SELECT*FROM product)전송단계
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT*FROM product");
		
		//3단계 결과 확인
		rs.next();
		
		String productName = rs.getString("p_name");
		//String productName = rs.getString(1);
		int productPrice = rs.getInt("p_price");
		//int productProce =rs.getInt(2);
		System.out.println("상품명:"+productName);
		System.out.println("가  격:"+productPrice);
		
		//각각의 객체를 close한다
		rs.close();
		stmt.close();
		con.close();
	}//end of main

}//end of class
