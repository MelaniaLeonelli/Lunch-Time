package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DriverManagerConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtenteDAO {
	
	public static String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
	public static String USER = "sisisi";
	public static String PASS = "password";

	public void register(String email, String nu, String pw) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO utente VALUES (?, ?, SHA2(CONCAT(?, 'criptalo'), 224), 0)");
		stmt.setString(1, email);     
		stmt.setString(2, nu);
		stmt.setString(3, pw);      
		stmt.executeUpdate();
	}
	
	public Integer login(String e, String p) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT emailutente, Password, ruolo FROM utente WHERE utente.emailutente = ? AND utente.Password = SHA2(CONCAT(?, 'criptalo'), 224)");
			stmt.setString(1, e);     
			stmt.setString(2, p);
			ResultSet rs = stmt.executeQuery();
			System.out.println("Utente: " + rs);
			try {
				while(rs.next()) {
					if(Integer.parseInt(rs.getString("utente.ruolo")) > 0) {
						return 1;
					}
					else{
						return 2;
					}
						
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return 3;
	}
	
	public Utente getUserData(String e, String p) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT emailutente, Nomeutente, ruolo FROM utente WHERE utente.emailutente = ?");
		stmt.setString(1, e);
		ResultSet rs = stmt.executeQuery();
		Utente u = new Utente();
		try {
			while(rs.next()) {
				u.setEmailutente(rs.getString("emailutente"));
				u.setNomeutente(rs.getString("Nomeutente"));
				u.setRuolo(Integer.parseInt(rs.getString("ruolo")));
			}
		} catch (SQLException e1) {
			return null;
		}
		return u;
	}
	
	/*  DA TESTARE 
	 * 
	 * public Utente getUserByCF(String cf) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT CodFiscale, Nome, Cognome FROM utente WHERE utente.CodFiscale = ?");
		stmt.setString(1, cf);
		ResultSet rs = stmt.executeQuery();
		Utente u = new Utente();
		try {
			while(rs.next()) {
				u.setCF(rs.getString("CodFiscale"));
				u.setNome(rs.getString("Nome"));
				u.setCognome(rs.getString("Cognome"));
			}
		} catch (SQLException e1) {
			return null;
		}
		return u;
	}*/

	public Boolean alreadyExist(String e) throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
		
			stmt = con.prepareStatement("SELECT emailutente FROM utente WHERE utente.emailutente = ?");
			stmt.setString(1, e);
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
