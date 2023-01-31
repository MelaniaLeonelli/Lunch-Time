package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DriverManagerConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;

public class TesseraDAO {
	
	public static String URL = "jdbc:mysql://localhost:3306/lunchtime";
	public static String USER = "root";
	public static String PASS = "password";
	
	public void addTessera(String email, int codice,int categoria) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO tessera VALUES (?, ?, 0, ?)");
		stmt.setInt(1, codice);
		stmt.setInt(2, categoria);     
		stmt.setString(3, email);     
		stmt.executeUpdate();
	}

	
	public Tessera getTesseraData(String e) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT codicetessera, categoria, saldo FROM tessera WHERE tessera.emailutente = ?");
		stmt.setString(1, e);
		ResultSet rs = stmt.executeQuery();
		Tessera t = new Tessera();
		try {
			while(rs.next()) {
				t.setCodicetessera(Integer.parseInt(rs.getString("codicetessera")));
				t.setCategoria(Integer.parseInt(rs.getString("categoria")));
				t.setSaldo(Integer.parseInt(rs.getString("saldo")));
			}
		} catch (SQLException e1) {
			return null;
		}
		return t;
	}
	

	public int ricaricaTessera(int c,int r) throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
		
			stmt = con.prepareStatement("UPDATE tessera SET saldo= saldo + ? WHERE codicetessera = ?;");
			stmt.setInt(1, r);
			stmt.setInt(2, c);
			stmt.executeUpdate();
			
              return r;
		}
	
	public Boolean alreadyExistT(String t) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
	
		stmt = con.prepareStatement("SELECT codicetessera FROM tessera WHERE tessera.codicetessera = ?");
		stmt.setString(1, t);
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e1) {
			return false;
		}
		return false;
	}
	
	
	
}
