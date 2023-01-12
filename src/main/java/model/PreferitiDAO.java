package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import controller.DriverManagerConnectionPool;

public class PreferitiDAO {
	
	public static String URL = "\"jdbc:mysql://127.0.0.1:3306/?user=root\"";
	public static String USER = "sisisi";
	public static String PASS = "password";
	
	
	public void addPreferito(String id,String em) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO preferisce VALUES(?, ?)");
		stmt.setString(1, id);
		stmt.setString(2, em);
		stmt.executeUpdate();
	}
	
	
	public ArrayList<String> getPreferiti(String em) throws SQLException, ClassNotFoundException {
		ArrayList<String> codes = new ArrayList<String>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT IdProdotto FROM preferisce WHERE emailutente = ?");
		stmt.setString(1, em);
		ResultSet rs = stmt.executeQuery();
		try {
		while(rs.next()) {
			String code = new String();
			code = rs.getString("emailutente");
			codes.add(code);
		}
		return codes;
		}catch(SQLException e) {
			return null;
		}
	}
	
}