package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContieneDAO {
	
	public static String URL = "jdbc:mysql://localhost:3306/lunchtime";
	public static String USER = "root";
	public static String PASS = "password";
	
	public void addToCart(String em, String pcode, int quantita, double importoTotale) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt; 
		stmt = con.prepareStatement("INSERT INTO contiene VALUES(?, ?, '1', ?);");
		stmt.setString(1, pcode);
		stmt.setString(2, em);
		stmt.setDouble(3, importoTotale);
		System.out.println("stmt:" + stmt);
		stmt.executeUpdate();
	}
	
	public void removeFromCart(String em, String IdProdotto) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("DELETE FROM contiene WHERE emailutente = ? AND IdProdotto = ?");
		stmt.setString(1, em);
		stmt.setString(2, IdProdotto);
		stmt.executeUpdate();
	}
	
	public Double getTotal(String em) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT SUM(ImportoTotale) FROM contiene WHERE emailutente = ?");
		stmt.setString(1, em);
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
			double tot = 0.0;
			tot = Double.parseDouble(rs.getString("sum(ImportoTotale)"));
			return tot;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0.0;
	}
	
	public void cleanCart(String em) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("DELETE FROM contiene WHERE emailutente = ?");
		stmt.setString(1, em);
		stmt.executeUpdate();
	}
	
}
