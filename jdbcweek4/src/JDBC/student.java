package JDBC;

import java.sql.*;

import java.io.IOException;
import java.util.Scanner;

public class student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s =new Scanner(System.in);
		Statement stmt =null;
		
	 try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","ep","ep123");
		System.out.println("Connection sucess");
		CallableStatement csmt = conn.prepareCall("{call student_pro(?,?,?)}");
		stmt = conn.createStatement();
		System.out.println("enter no of records to be inserted:");
		
		int n =s.nextInt();
		for(int i=0;i<n;i++) {
			
			System.out.println("Enter id,name,age");
		long id = s.nextLong();
		String name = s.next();
		int age =s.nextInt();
		csmt.setLong(1, id);
		csmt.setString(2, name);
		csmt.setInt(3, age);
		csmt.execute();
		System.out.println("Values inserted");
		}
		
		System.out.println("Query to student,age<21");
		
		String sql ="SELECT id, name,age FROM student" +" where age<21" ;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			String name = rs.getString("name");
			
			System.out.println("id:"+ id);
			System.out.println(",Name: "+ name);
			System.out.println(",Age:"+ age);
			System.out.println("\n");
						
		}
		rs.close();
		System.out.println("execution completed");
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

	}

}
