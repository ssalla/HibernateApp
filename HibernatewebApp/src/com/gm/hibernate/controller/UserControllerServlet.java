package com.gm.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gm.hibernate.dao.UserDAO;

public class UserControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{

		String userName = request.getParameter("userName");
		String password = request.getParameter("password1");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String operation=request.getParameter("operation");

		
		//HttpSession 
		HttpSession ses=request.getSession();
		ses.setAttribute("name", userName);
		
		
		HttpSession session = request.getSession(true);
		try
		{
			if(operation.equals("insert"))
			{
				UserDAO userDAO = new UserDAO();
				userDAO.addUserDetails(userName, password, email, phone, city);
				response.sendRedirect("Success");

			}
			else if(operation.equals("update"))
			{
				
				UserDAO userDAO = new UserDAO();
				if(userDAO.updateUserDetails(userName, password, email, phone, city))
				{
					response.sendRedirect("Success");
				}
				else
				{
					response.sendRedirect("Failure");	
				}
			}
			else if(operation.equals("delete")) {
				
				UserDAO userDAO = new UserDAO();
				if(userDAO.deleteUserDetails(userName, password))
				{
					response.sendRedirect("Delete");
				}
				else
				{
					response.sendRedirect("Failure");	
				}
			}

		}
		catch (Exception e)
		{

			e.printStackTrace();
		}

	}
}
