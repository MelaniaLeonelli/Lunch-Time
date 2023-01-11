package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DriverManagerConnectionPool {
	 private static List<Connection> freeDbConnections;
	 
	 static {
	 freeDbConnections = new LinkedList<Connection>();

	 	try {
	 		Class.forName("com.mysql.jdbc.Driver");
	 		} catch (ClassNotFoundException e) {
	 			System.out.println("DB driver not found!" + e);
	 		}
	 }
	 
	 private static Connection createDBConnection() throws SQLException {
		 Connection newConnection = null;
		 String url = "jdbc:mysql://localhost:3306/lunchtime";
		 String user = "sisisi";
		 String pass = "password";
		 newConnection = DriverManager.getConnection(url, user, pass);
		 newConnection.setAutoCommit(false);
		 return newConnection;
		 }

	 public static synchronized Connection getConnection() throws SQLException {
		 Connection connection;
		 if (!freeDbConnections.isEmpty()) {
			 connection = (Connection) freeDbConnections.get(0);
			 DriverManagerConnectionPool.freeDbConnections.remove(0);
			 try {
				 if (connection.isClosed())
					 connection = DriverManagerConnectionPool.getConnection();
			 	} catch (SQLException e) {
			 		connection = DriverManagerConnectionPool.getConnection();
			 	}
		 }
		 else
			 connection = DriverManagerConnectionPool.createDBConnection();
		 return connection;
		 }
	 
	 public static synchronized void releaseConnection(Connection connection) {
		 DriverManagerConnectionPool.freeDbConnections.add(connection);
	 }
}
