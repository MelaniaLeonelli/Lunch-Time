package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DriverManagerConnectionPool;

public class AcquistoDAO {
	
<<<<<<< HEAD
	public static String URL = "\"jdbc:mysql://127.0.0.1:3306/?user=root\"";
=======
	public static String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
>>>>>>> b5f171113ed8691351bdd32889e44f1258214da2
	public static String USER = "sisisi";
	public static String PASS = "password";

	public void addAcquisto(int ocode, String pcode, double costo) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO acquisto VALUES(?, ?, ?)");
		stmt.setInt(1, ocode);
		stmt.setString(2, pcode);
		stmt.setDouble(3, costo);
		stmt.executeUpdate();
	}
	
	public ArrayList<String> getAcquisti(int codOrdine) throws SQLException, ClassNotFoundException {
		ArrayList<String> codes = new ArrayList<String>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT CodProdotto FROM acquisto WHERE CodOrdine = ?");
		stmt.setInt(1, codOrdine);
		ResultSet rs = stmt.executeQuery();
		try {
		while(rs.next()) {
			String code = new String();
			code = rs.getString("CodProdotto");
			codes.add(code);
		}
		return codes;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public double getPrezzo(int codOrdine, String codProdotto) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT * FROM acquisto WHERE CodOrdine = ?  AND CodProdotto = ?");
		stmt.setInt(1, codOrdine);
		stmt.setString(2, codProdotto);
		ResultSet rs = stmt.executeQuery();
		double prezzo = 0.0;
		while(rs.next()) {
			prezzo = (Double.parseDouble(rs.getString("Costo")));
		}
		return prezzo;
	}
	
}