package com.preethi.fc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FoodCartDb {
	
	public static List<FoodDetails> getFoodList() throws ClassNotFoundException, SQLException{
		
		String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
		String userName = "root";
		String password = "canara123$";
		
		ArrayList<FoodDetails> food = new ArrayList<FoodDetails>();
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Food.foodcart;");
		
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String item = rs.getNString("item");
			float price = rs.getFloat("price");
			
			FoodDetails foodDetails = new FoodDetails(id, item, price);
			food.add(foodDetails);
		}

		return food;
		
	}
	public static void postFoodList(int id, String item, float price) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
		String userName = "root";
		String password = "canara123$";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement stmt = con.createStatement();
		stmt.executeUpdate("INSERT INTO `Food`.`foodcart` (`id`, `item`, `price`) VALUES ('" + id+ "', '" + item + "', '" + price + "')");
		
	}

}
