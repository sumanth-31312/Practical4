package JDBC;
import java.sql.*;
import java.io.IOException;

import java.util.Scanner;

public class inlab_1 {
	
	public static void main(String[] args) {
		Statement stmt = null;
		Scanner s = new Scanner(System.in);
		
		try {
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep123");
		System.out.println("Connection Succeed!");
		// 190031312
		
		CallableStatement stm = conn.prepareCall("{call sales_pro(?,?,?)}");
		
		stmt = conn.createStatement();
		System.out.println("Enter Number Items Bought");
		int n = s.nextInt();
		for(int i=0; i<n ; i++) {
		System.out.println("Enter Item id :");
		int item_id =s.nextInt();
		System.out.println("Enter Item Name :");
		String item_name = s.next();
		System.out.println("Enter Cost of Item :");
		int cost_of_item = s.nextInt();
		stm.setInt(1, item_id);
		stm.setString(2, item_name);
		stm.setInt(3, cost_of_item);
		stm.execute();
		System.out.println("Values Entered !");
		}
		System.out.println("\n");
		String sql1 = "SELECT SUM(cost_of_item) FROM sales";
		ResultSet total = stmt.executeQuery(sql1);
		total.next();
		System.out.println("Total Cost of Items :" + 
		total.getString(1));
		System.out.println("\n");
		// 190031312
		System.out.println("Listing the items bought");
		String sql = "SELECT * FROM sales";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			
		 int item_id = rs.getInt("item_id");
		 String item_name = rs.getString("item_name");
		 int cost_of_item = rs.getInt("cost_of_item");
		 
		 System.out.print("Item ID: " + item_id);
		 System.out.print(", Item Name: " + item_name);
		 System.out.print(", Cost Of Item: " + cost_of_item);
		 System.out.println("\n");
		 }
		 rs.close();
		// 190031312
		 System.out.println("Execution completed!");
		 
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
	}
	
}


