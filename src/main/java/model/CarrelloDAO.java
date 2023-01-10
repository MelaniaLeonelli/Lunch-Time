
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
	
	public ArrayList<Contiene> getCart(String em) throws ClassNotFoundException, SQLException{
		ArrayList<Contiene> carrello = new ArrayList<Contiene>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT emailutente, IdProdotto, quantita, ImportoTotale FROM Contiene WHERE Contiene.CodFiscale = ?");
		stmt.setString(1, em);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Contiene c = new Contiene();
			c.setEmailutente(rs.getString("emailutente"));
			c.setIdprodotto(rs.getString("IdProdotto"));
			c.setQuantita(Integer.parseInt(rs.getString("quantita")));
			c.setimportoTotale(Double.parseDouble(rs.getString("ImportoTotale")));
			carrello.add(c);
		}
		return carrello;
	}
	
	public void emptyBasket(String em) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("DELETE FROM Contiene WHERE CodFiscale = ?");
		stmt.setString(1, em);
		stmt.executeUpdate();
	}
}
