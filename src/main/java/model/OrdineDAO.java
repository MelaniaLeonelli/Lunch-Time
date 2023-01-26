package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DriverManagerConnectionPool;

public class OrdineDAO {
	
	public static String URL = "jdbc:mysql://localhost:3306/lunchtime";
	public static String USER = "root";
	public static String PASS = "password";

	public ArrayList<Ordine> getOrders(String em) throws ClassNotFoundException{
		ArrayList<Ordine> ordini = new ArrayList<Ordine>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT CodOrdine, Data, ImportoTotale, emailutente FROM Ordine WHERE Ordine.emailutente = ?");
			stmt.setString(1, em);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Ordine or = new Ordine();
				or.setCodordine(rs.getInt("CodOrdine"));
				or.setData(rs.getString("Data"));
				or.setImportototale(Double.parseDouble(rs.getString("ImportoTotale")));
				or.setEmailutente(rs.getString("emailutente"));
				ordini.add(or);
			}
			return ordini;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<Ordine> getAllOrders() throws ClassNotFoundException{
		ArrayList<Ordine> ordini = new ArrayList<Ordine>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT CodOrdine, Data, emailutente FROM Ordine");
			ResultSet rs;
			rs = stmt.executeQuery();
			while(rs.next()) {
				Ordine or = new Ordine();
				or.setCodordine(rs.getInt("CodOrdine"));
				or.setData(rs.getString("Data"));
				or.setEmailutente(rs.getString("emailutente"));
				ordini.add(or);
			}
			return ordini;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public Ordine getOrderByCode(int CodOrdine) throws ClassNotFoundException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT CodOrdine, Data, ImportoTotale, emailutente FROM Ordine WHERE Ordine.CodOrdine = ?");
			stmt.setInt(1, CodOrdine);
			ResultSet rs;
			rs = stmt.executeQuery();
			Ordine or = new Ordine();
			while(rs.next()) {
				or.setCodordine(rs.getInt("CodOrdine"));
				or.setData(rs.getString("Data"));
				or.setImportototale(Double.parseDouble(rs.getString("ImportoTotale")));
				or.setEmailutente(rs.getString("emailutente"));
			}
			return or;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public void order(int CodOrdine, String em, String data, double importoTotale) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO ordine VALUES (?, ?, ?, ?)");
		stmt.setInt(1, CodOrdine);
		stmt.setString(2, data);
		stmt.setDouble(3, importoTotale);
		stmt.setString(4, em);
		stmt.executeUpdate();
	}
	
	public int getLatestOrder() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT CodOrdine FROM ordine WHERE CodOrdine=(SELECT max(CodOrdine) FROM ordine)");
		ResultSet rs;
		rs = stmt.executeQuery();
		 try {
				while(rs.next()) {
				int latestOrder;
				latestOrder = rs.getInt("CodOrdine");
				return latestOrder;
				}
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
			return 0;
	}
	


public ArrayList<Ordine> getOrdersUtente(String emailutente) throws ClassNotFoundException{
	ArrayList<Ordine> ordini = new ArrayList<Ordine>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT CodOrdine, Data, emailutente FROM Ordine WHERE emailutente=?");
		stmt.setString(1, emailutente);
		ResultSet rs;
		rs = stmt.executeQuery();
		while(rs.next()) {
			Ordine or = new Ordine();
			or.setCodordine(rs.getInt("CodOrdine"));
			or.setData(rs.getString("Data"));
			or.setEmailutente(rs.getString("emailutente"));
			ordini.add(or);
		}
		return ordini;
	}catch(SQLException e) {
		return null;
	}
}
}