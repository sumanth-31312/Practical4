package JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.*;

public class postlab_1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 190031312
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep123");
		System.out.println("Connection Success!");
		Statement stmt = con.createStatement();
		
		PreparedStatement psmt=con.prepareStatement("insert into wildlife values(?,?,?,?)"); 
		System.out.println("Enter number of values to be inserted :");
		int n = s.nextInt();
		// 190031312
		
		for(int i = 0; i<n; i++) {
		System.out.println("Enter Name :");
		String name = s.next();
		System.out.println("Enter Category :");
		String category = s.next();
		System.out.println("Enter Path of image :");
		 String image = s.next();
		System.out.println("Enter Path of Description File :");
		String file = s.next();
		
		psmt.setString(1, name);
		psmt.setString(2, category);
		
		FileInputStream fin = new FileInputStream(image);
		psmt.setBinaryStream(3, fin);
		FileReader fr=new FileReader(file); 
		psmt.setCharacterStream(4, fr);
		psmt.execute();
		System.out.println("Values inserted!");
		}// 190031312
		ResultSet rs = stmt.executeQuery("SELECT * FROM wildlife");
		while(rs.next()) {
			
		System.out.println("Name :"+rs.getString("name")+"\n");
		System.out.println("Category :"+rs.getString("category")+"\n");
		System.out.println("Image :"+rs.getBlob("image")+"\n");
		System.out.println("Description File :"+rs.getClob("description_file"));
		}
		System.out.println("Execution completed!");
		}
		
		catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
	} 

}
