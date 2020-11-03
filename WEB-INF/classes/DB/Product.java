
package DB;

import java.util.Scanner;
import java.io.*;
import java.sql.*;
import java.util.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.*;


public class Product extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			  throws IOException, ServletException{
		String barcode=req.getParameter("barCode");
		String name=req.getParameter("prodName");
		String color=req.getParameter("prodColor");
		String desc=req.getParameter("prodDesc");

		List<String> result = new ArrayList<>(); 
		PrintWriter pwriter = res.getWriter();
	
		String url = "jdbc:mysql://localhost:3306/productdb";
		String dbUser = "root";
		String dbPassword = "Mkokar1!";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection(url, dbUser, dbPassword);
			Statement myStmt = myConn.createStatement();                              
			
			ResultSet searchResult = myStmt.executeQuery("select * from products " + " where barcode='" + barcode+ "';"); 
			
			if(!searchResult.next()) {
				myStmt.executeUpdate("insert into products " + " (barcode, color,name,description) " + " values('" + barcode + "', '" + color + "', '" + name + "', '"+ desc + "');");

				result.add(barcode);
				result.add(name);
				result.add(color);
				result.add(desc);

				req.setAttribute("styles",result);

				RequestDispatcher view = req.getRequestDispatcher("result.jsp");

				view.forward(req,res);


			}
			else {
				req.setAttribute("styles",result);
				RequestDispatcher view = req.getRequestDispatcher("result.jsp");
				view.forward(req,res);
			}
			
		}catch(Exception exc) {
			pwriter.println("<p>Error occured: " + exc.toString() + "</p>");
			System.out.println("An error occurred while connecting MySQL databse: demo");
			exc.printStackTrace();
			System.out.println("\nError again");
		}
		

	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			  throws IOException, ServletException{
	}
}
