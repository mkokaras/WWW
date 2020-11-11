
package Util;

import Entity.ProductEn;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.*;
import java.io.PrintWriter;

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

		try {
			ProductEn newProduct = new ProductEn(barcode,color,name,desc);
			

			SessionFactory factory = new Configuration().configure()
									.addAnnotatedClass(ProductEn.class)
									.buildSessionFactory();
			
			Session session = factory.getCurrentSession();session.beginTransaction();
			
			session.save(newProduct);

			try {
				
				session.getTransaction().commit();
			}catch(javax.persistence.PersistenceException exc) {

				
				req.setAttribute("styles",result);
				RequestDispatcher view = req.getRequestDispatcher("result.jsp");
				view.forward(req,res);
			}
			finally{}
			result.add(barcode);
			result.add(name);
			result.add(color);
			result.add(desc);

			req.setAttribute("styles",result);

			RequestDispatcher view = req.getRequestDispatcher("result.jsp");

			view.forward(req,res);

			factory.close();
			
		}catch(Exception e){
			pwriter.println("<h2>An error occurred while connecting to MySQL database</h2>");
			pwriter.println(e.toString());
			System.out.println("An error occurred while connecting MySQL databse");
			System.out.println(e.toString());
		}
		pwriter.close();
		

	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			  throws IOException, ServletException{
	}
}
