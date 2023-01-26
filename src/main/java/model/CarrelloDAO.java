
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DriverManagerConnectionPool;

public class CarrelloDAO {
	
	public static String URL = "jdbc:mysql://localhost:3306/lunchtime";
	public static String USER = "root";
	public static String PASS = "password";
	
	public ArrayList<Contiene> getCart(String em) throws ClassNotFoundException, SQLException{
		System.out.println("entrato in carrello dao");
		ArrayList<Contiene> carrello = new ArrayList<Contiene>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);System.out.println("entrato nel database");
		PreparedStatement stmt;System.out.println("prima della select");
		stmt = con.prepareStatement("SELECT IdProdotto, quantita, ImportoTotale FROM Contiene WHERE  emailutente= ?");System.out.println("select fatta");
		stmt.setString(1, em);System.out.println("dopo la select");
		ResultSet rs = stmt.executeQuery();System.out.println("prima del while");
		while(rs.next()) {
			Contiene c = new Contiene();
			c.setEmailutente(em);
			c.setIdprodotto(rs.getString("IdProdotto"));
			c.setQuantita(Integer.parseInt(rs.getString("quantita")));System.out.println("prima di set importo mammt");
			c.setimportoTotale(Double.parseDouble(rs.getString("ImportoTotale")));System.out.println("dopo set importo mammt");
			carrello.add(c);
		}
		return carrello;
	}
	
	public void emptyBasket(String em) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("DELETE FROM Contiene WHERE emailutente = ?");
		stmt.setString(1, em);
		stmt.executeUpdate();
	}
}
