package by.bsuir.spp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import by.bsuir.spp.resource.ConfigurationManager;

public class ConnectionFactory {
	//static reference to itself
	private static ConnectionFactory instance = 
			new ConnectionFactory();
	
	String url =  ConfigurationManager.getProperty("dB_path");
	String user = ConfigurationManager.getProperty("dB_user");
	String password = ConfigurationManager.getProperty("dB_password");
	String driverClass = ConfigurationManager.getProperty("dB_driver");
/*	
	String url =  "jdbc:mysql://localhost:3306/itcompany";
	String user = "root";
	String password = "7586";
	String driverClass = "com.mysql.jdbc.Driver"; 
*/	
	//private constructor
	private ConnectionFactory() {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionFactory getInstance()	{
		return instance;
	}
	
	public Connection getConnection() throws SQLException, 
	ClassNotFoundException {
		Connection connection = 
			DriverManager.getConnection(url, user, password);
		return connection;
	}	

}
