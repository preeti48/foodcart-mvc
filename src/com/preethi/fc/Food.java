package com.preethi.fc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 // Servlet implementation class Food

@WebServlet("/Food")
public class Food extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the data from db
//		String[] foodItems = {"biri", "chappa", "curry"};
//		request.setAttribute("foodItems", foodItems);
		
		 try {
			List<FoodDetails> foodItems = FoodCartDb.getFoodList();
			request.setAttribute("foodItems", foodItems);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// redirect to jsp
		RequestDispatcher despatcher = request.getRequestDispatcher("show-food.jsp");
		despatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id =  request.getParameter("id");
			String item = request.getParameter("item");
			String price = request.getParameter("price");
			FoodCartDb.postFoodList(Integer.parseInt(id), item, Float.parseFloat(price));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//response.getWriter().append(test);
		
		
	}
}
