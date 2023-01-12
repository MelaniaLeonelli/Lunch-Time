package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DriverManagerConnectionPool;

public class PreferisceDAO {
	
	public static String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
	public static String USER = "sisisi";
	public static String PASS = "password";

	public void addPreferito(String IdProdotto, String em) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO preferisce VALUES(?, ?)");
		stmt.setString(1, IdProdotto);
		stmt.setString(2, em);
		stmt.executeUpdate();
	}
	
	public void deletePreferito(String IdProdotto, String em) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("DELETE INTO preferisce VALUES(?, ?)");
		stmt.setString(1, IdProdotto);
		stmt.setString(2, em);
		stmt.executeUpdate();
	}
	
	
}