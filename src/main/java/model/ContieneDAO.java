package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContieneDAO {
	
	public static String URL = "\"jdbc:mysql://127.0.0.1:3306/?user=root\"";
	public static String USER = "sisisi";
	public static String PASS = "password";
	
	public void addToCart(String e, String idprodotto, int quantità, double importoTotale) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO contiene VALUES(?, ?, '1', ?);");
		stmt.setString(1, idprodotto);
		stmt.setString(2, e);
		stmt.setDouble(3, importoTotale);
		System.out.println("stmt:" + stmt);
		stmt.executeUpdate();
	}
	
	public void removeFromCart(String e, String idprodotto) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("DELETE FROM contiene WHERE emailutente = ? AND idprodotto = ?");
		stmt.setString(1, e);
		stmt.setString(2, idprodotto);
		stmt.executeUpdate();
	}
	
	public Double getTotal(String em) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT SUM(importoTotale) FROM contiene WHERE emailutente = ?");
		stmt.setString(1, em);
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
			double tot = 0.0;
			double iva = 0.22;
			tot = Double.parseDouble(rs.getString("sum(importoTotale)"));
			tot += tot * iva;
			return tot;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0.0;
	}
	
}
