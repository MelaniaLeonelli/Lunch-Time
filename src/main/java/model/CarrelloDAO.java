
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DriverManagerConnectionPool;

public class CarrelloDAO {
	
	public static String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
	public static String USER = "sisisi";
	public static String PASS = "password";
	
	public ArrayList<Contiene> getCart(String e) throws ClassNotFoundException, SQLException{
		ArrayList<Contiene> carrello = new ArrayList<Contiene>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT emailutente, IdProdotto, quantita, importoTotale FROM Contiene WHERE Contiene.emailutente = ?");
		stmt.setString(1, e);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Contiene c = new Contiene();
			c.setEmailutente(rs.getString("emailutente"));
			c.setIdprodotto(rs.getString("IdProdotto"));
			c.setQuantita(Integer.parseInt(rs.getString("quantita")));
			c.setimportoTotale(Double.parseDouble(rs.getString("importoTotale")));
			carrello.add(c);
		}
		return carrello;
	}
	
	public void emptyBasket(String e) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("DELETE FROM Contiene WHERE emailutente = ?");
		stmt.setString(1, e);
		stmt.executeUpdate();
	}
}
