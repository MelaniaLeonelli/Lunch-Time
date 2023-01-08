package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DriverManagerConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;

public class TesseraDAO {
	
	public static String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
	public static String USER = "sisisi";
	public static String PASS = "password";

	
	public Tessera getTesseraData(String e) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
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
				t.setSaldo(Float.parseFloat(rs.getString("saldo")));
			}
		} catch (SQLException e1) {
			return null;
		}
		return t;
	}
	

	public float ricaricaTessera(String e,float r) throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
		
			stmt = con.prepareStatement("UPDATE tessera SET saldo= saldo + ? FROM tessera WHERE tessera.codicetessera = ?");
			stmt.setFloat(1, r);
			stmt.setString(2, e);
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
