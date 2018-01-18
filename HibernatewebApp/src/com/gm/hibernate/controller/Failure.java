package com.gm.hibernate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Failure extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		writer.println("<html>" + "<body bgcolor='LightGray'>" + "<center>"
				+ "Userdetails are not Aviable in database...Please provide valid details...."+" </br> "+ "</center>" + "</body>" 
				+ "</html>");
		
		
	}

}
