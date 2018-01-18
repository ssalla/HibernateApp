package com.gm.hibernate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gm.hibernate.bean.User;

public class UserDAO
{

	public void addUserDetails(String userName, String password, String email,String phone, String city) 
	{
		try {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();

			// 3. Get Session object
			Session session = sessionFactory.openSession();

			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			
			User user = new User();
			
			user.setUserName(userName);
			user.setPassword1(password);
			user.setEmail(email);
			user.setCity(city);
			user.setPhone(phone);
			
			session.save(user);
			
			transaction.commit();
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e)
		{
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	}
	public boolean updateUserDetails(String userName, String password, String email,String phone, String city) 
	{
		int id = 0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","root");
			
			String sql="select id from user where USER_NAME='"+userName+"'";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();

			// 3. Get Session object
			Session session = sessionFactory.openSession();

			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			
			
			if(id != 0)
			{
				User user1=(User) session.get(User.class, id);
				
				user1.setUserName(userName);
				user1.setPassword1(password);
				user1.setEmail(email);
				user1.setCity(city);
				user1.setPhone(phone);
				
				session.update(user1);
				
				transaction.commit();
				System.out.println("\n\n Details Added \n");
			}
			else
			{
				System.out.println("person not avaible");
				return false;
			}

		} catch (HibernateException e)
		{
			System.out.println(e.getMessage());
			System.out.println("error");
		}
		return true;
	}
	
	public boolean deleteUserDetails(String userName, String password) 
	{
		int id = 0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","root");
			
			String sql="select id from user where USER_NAME = '"+userName+"'";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();

			// 3. Get Session object
			Session session = sessionFactory.openSession();

			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			
			
			if(id != 0)
			{
				User user1=(User) session.get(User.class, id);
				
				user1.getUserName();
				//user1.setPassword1(password);
				session.delete(user1);
				
				transaction.commit();
				System.out.println("\n\n Record deleted \n");
			}
			else
			{
				System.out.println("person not avaible");
				return false;
			}

		} catch (HibernateException e)
		{
			System.out.println(e.getMessage());
			System.out.println("error");
		}
		return true;
	}
}
