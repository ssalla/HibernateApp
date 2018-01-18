package com.gm.hibernate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Success extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		writer.println("<html>" + "<body bgcolor='LightGray'>" + "<center>"
				+ "Details Added Successfully"+" </br> "+ "</center>" + "</body>" 
				+ "</html>");
		
		writer.println("<html>" + "<body bgcolor='LightGray'>" + "<center>"
				+ "<li><a href=register.jsp>Add More peoples...</li></br>" + "</center>" + "</body>" 
				+ "</html>");
		
		writer.println("<html>" + "<body bgcolor='LightGray'>" + "<center>"
				+ "<li><a href=update.html>Update person data...</li></br>" + "</center>" + "</body>" 
				+ "</html>");
		
		writer.println("<html>" + "<body bgcolor='LightGray'>" + "<center>"
				+ "<li><a href=delete.html>Delete Person Data...</li></br>" + "</center>" + "</body>" 
				+ "</html>");
		
	}

}
