package jdbc;
import java.sql.*;
public class CreateJDBC {
	//main method
	public static void main(String[] args) {
		//JDBC절차에 필요 인스턴스 및 정보 선언
		Connection con =null;
		Statement stmt = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		try {
			//1.Connextion ::Login 과정을 추상화한 interface
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1.driver loaing OK");
			
			con = DriverManager.getConnection(url,"scott","tiger");
			System.out.println("2. connection 인스턴스 생성 완료");
			
			//2.Statement::Query 전송을 추상화한 interface
			stmt = con.createStatement();
			System.out.println("3.statement객체 생성 완료");
			
			//Create Query만들기
			String createSql =
					"Create TABLE firstJDBC"+
			"(no	Number(3),"+
			"name VARCHAR2(20),"+
			"EMALL VARCHAR2(30),"+
			"address VARCHAR2(50))";
			
			System.out.println("::QUERY 전송결과:"+stmt.executeUpdate(createSql));
			System.out.println("4.query 전송완료");
			
			
		}catch(ClassNotFoundException e) {
			System.out.println("\n===>Driver Loading 시  Exception 발생 \n");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("\n ==>JDBC절차 중 Excetion 발생:"+e.getErrorCode());
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			}catch(SQLException e) {
				System.out.println("\n==> jdbc절차 중 exception 발생:"+e.getErrorCode());
				e.printStackTrace();
			}
		}
		
		/*
		//1.Connextion ::Login 과정을 추상화한 interface
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1.driver loaing OK");
		}catch(ClassNotFoundException e) {
			System.out.println("\n===>Driver Loading 시  Exception 발생 \n");
			e.printStackTrace();
		}
		
		try{
			con = DriverManager.getConnection(url,"scott","tiger");
			System.out.println("2. connection 인스턴스 생성 완료");
		}catch(SQLException e) {
			System.out.println("\n ==>JDBC절차 중 Excetion 발생:"+e.getErrorCode());
			e.printStackTrace();
		}
		
		//2.Statement::Query 전송을 추상화한 interface
		try {
			stmt = con.createStatement();
			System.out.println("3.statement객체 생성 완료");
		}catch(SQLException e) {
			System.out.println("\n==>JDBC 절차 중 Exception 발생:"+e.getErrorCode());
			e.printStackTrace();
		}
		
		//Create Query만들기
		String createSql =
				"Create TABLE firstJDBC"+
		"(no	Number(3),"+
		"name VARCHAR2(20),"+
		"EMALL VARCHAR2(30),"+
		"address VARCHAR2(50))";
		
		try {
			System.out.println("::QUERY 전송결과:"+stmt.executeUpdate(createSql));
			System.out.println("4.query 전송완료");
		}catch(SQLException e) {
			System.out.println("\n ==> JDBC절차 중 Exception 발생"+e.getErrorCode());
			e.printStackTrace();
		}
		
		try {
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		}catch(SQLException e) {
			System.out.println("\n==> jdbc절차 중 exception 발생:"+e.getErrorCode());
			e.printStackTrace();
		}
		
		*/
		
		
	}//end of main

}//end of class
