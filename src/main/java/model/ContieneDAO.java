package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContieneDAO {
	
<<<<<<< HEAD
	public static String URL = "\"jdbc:mysql://127.0.0.1:3306/?user=root\"";
	public static String USER = "sisisi";
	public static String PASS = "password";
	
	public void addToCart(String e, String idprodotto, int quantità, double importoTotale) throws ClassNotFoundException, SQLException {
=======
	public static String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
	public static String USER = "sisisi";
	public static String PASS = "password";
	
	public void addToCart(String em, String IdProdotto, int quantita, double importoTotale) throws ClassNotFoundException, SQLException {
>>>>>>> b5f171113ed8691351bdd32889e44f1258214da2
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO contiene VALUES(?, ?, '1', ?);");
<<<<<<< HEAD
		stmt.setString(1, idprodotto);
		stmt.setString(2, e);
=======
		stmt.setString(1, IdProdotto);
		stmt.setString(2, em);
>>>>>>> b5f171113ed8691351bdd32889e44f1258214da2
		stmt.setDouble(3, importoTotale);
		System.out.println("stmt:" + stmt);
		stmt.executeUpdate();
	}
	
<<<<<<< HEAD
	public void removeFromCart(String e, String idprodotto) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("DELETE FROM contiene WHERE emailutente = ? AND idprodotto = ?");
		stmt.setString(1, e);
		stmt.setString(2, idprodotto);
=======
	public void removeFromCart(String em, String IdProdotto) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("DELETE FROM contiene WHERE emailutente = ? AND IdProdotto = ?");
		stmt.setString(1, em);
		stmt.setString(2, IdProdotto);
>>>>>>> b5f171113ed8691351bdd32889e44f1258214da2
		stmt.executeUpdate();
	}
	
	public Double getTotal(String em) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
<<<<<<< HEAD
		stmt = con.prepareStatement("SELECT SUM(importoTotale) FROM contiene WHERE emailutente = ?");
=======
		stmt = con.prepareStatement("SELECT SUM(ImportoTotale) FROM contiene WHERE emailutente = ?");
>>>>>>> b5f171113ed8691351bdd32889e44f1258214da2
		stmt.setString(1, em);
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
			double tot = 0.0;
			double iva = 0.22;
<<<<<<< HEAD
			tot = Double.parseDouble(rs.getString("sum(importoTotale)"));
=======
			tot = Double.parseDouble(rs.getString("sum(ImportoTotale)"));
>>>>>>> b5f171113ed8691351bdd32889e44f1258214da2
			tot += tot * iva;
			return tot;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0.0;
	}
	
}
