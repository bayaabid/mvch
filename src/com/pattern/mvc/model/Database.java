package com.pattern.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	private static Database instance = new Database();
	
	private Connection connection;
	
	private Database(){
		
	}
	
	public static Database getInstance(){
		return instance ;
	}
	
	/*
	private static Database instanceOld;
	public static Database getInstanceOld(){
		if(instanceOld == null){
			instanceOld = new Database();
		} 
		 return instanceOld;
	}
	*/
	
	public void connect() throws Exception{
		System.out.println("Connected to database");
		if(connection != null)
			return;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Driver not found");
		}
		
		String url = String.format("jdbc:mysql://localhost:%d/pattern", 3307);
		
		connection = DriverManager.getConnection(url, "root", "");
	}
	
	public void disconnect(){
		System.out.println("Disconnected");
		
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("can't close connection");
			}
		}
		
	}
}
