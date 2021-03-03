package JDBC;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.*;

public class postlab_2 {
	public static void main(String[] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		
		try {
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 190031312
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep123");
		System.out.println("Connection Success!");
		Statement stmt = con.createStatement();
		System.out.println("Enter 1 to save Animals and enter 2 to save plant files");
		int m = s.nextInt();
		
		if(m == 1) {
		ResultSet rs = stmt.executeQuery("SELECT * FROM wildlife WHERE category = 'Animal'");
		Blob blob;
		Clob clob;
		byte[] b;
		int i = 1;
		while(rs.next()) {
		i++;
		File f=new
		File("C:\\Users\\SUMANTH KUMAR\\Desktop\\Animal\\animal" + i + ".jpg");
		 FileOutputStream image0=new
		FileOutputStream(f);
		 blob=rs.getBlob("image");
		 b = blob.getBytes(1, 
		(int)blob.length());
		 image0.write(b);
		 
		 File f0=new
		File("C:\\Users\\SUMANTH KUMAR\\Desktop\\Animal\\animal " + i + ".txt");
		 FileOutputStream file0 = new
		FileOutputStream(f0);
		 clob = 
		rs.getClob("description_file");
		 Reader r=clob.getCharacterStream(); 
		 while((i=r.read())!=-1) 
		 file0.write((char)i); 
		}
		System.out.println("Saved!");
		}
		else {
		System.out.println("Exiting...");
		}
		int n = s.nextInt();
		if(n == 2) {
		ResultSet rs1 = stmt.executeQuery("SELECT * FROM wildlife WHERE category = 'Plant'");
		Blob b1;
		Clob c;
		byte[] by;
		int j = 1;
		while(rs1.next()) {
		j++;
		File f1=new
		File("C:\\Users\\SUMANTH KUMAR\\Desktop\\Plant\\plant " + j + ".jpg");
		FileOutputStream image=new FileOutputStream(f1);
		b1=rs1.getBlob("image");
		by = b1.getBytes(1, (int)b1.length());
		image.write(by);
		File f2=new
		File("C:\\Users\\SUMANTH KUMAR\\Desktop\\Plant\\plant " + j + ".txt");
		FileOutputStream file1 = new
		FileOutputStream(f2);
		c = rs1.getClob("description_file");
		Reader read =c.getCharacterStream(); 
		while((j=read.read())!=-1) 
		file1.write((char)j); 
		}
		System.out.println("Saved!");
		}
		else {
		System.out.println("Exiting...");
		}
		System.out.println("Execution completed!");
		
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}// 190031312
		
	} 
	
}


