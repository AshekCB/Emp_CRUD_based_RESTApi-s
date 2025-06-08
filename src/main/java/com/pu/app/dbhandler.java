package com.pu.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class dbhandler 
{
	@Value("${spring.datasource.url}")
	private String dburl;
	
	@Value("${spring.datasource.username}")
	private String dbuser;
	
	@Value("${spring.datasource.password}")
	private String dbpassword;
	
	public Connection getConnection() throws ClassNotFoundException,SQLException
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dburl, dbuser, dbpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
