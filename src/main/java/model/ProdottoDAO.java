package model;
import java.sql.*;
import java.util.ArrayList;

import controller.DriverManagerConnectionPool;

public class ProdottoDAO {
	
	public static String URL = "\"jdbc:mysql://127.0.0.1:3306/?user=root\"";
	public static String USER = "sisisi";
	public static String PASS = "password";
	
	public ArrayList<Prodotto> doRetrieveByName(String nome) throws ClassNotFoundException{
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT nome, idprodotto, categoria, prezzo, immagine, descrizione, disponibile FROM prodotto WHERE prodotto.nome LIKE ?");
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Prodotto p = new Prodotto();
				p.setNome(rs.getString("nome"));
				p.setIdprodotto(rs.getString("idprodotto"));
				p.setCategoria(rs.getString("categoria"));
				p.setPrezzo(Double.parseDouble(rs.getString("prezzo")));
				p.setImmagine(rs.getString("immagine"));
				p.setDescrizione(rs.getString("descrizione"));
				p.setDisponibile(Integer.parseInt(rs.getString("disponibile")));
				prodotti.add(p);
			}
			return prodotti;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<Prodotto> doRetrieveByCategoria(String cat) throws ClassNotFoundException, SQLException{
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT nome, codprodotto, categoria, prezzo, immagine, descrizione, disponibile FROM prodotto WHERE prodotto.categoria LIKE ?");
			stmt.setString(1, "%" + cat + "%");
			System.out.println("stmt:" + stmt);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Prodotto p = new Prodotto();
				p.setNome(rs.getString("nome"));
				p.setIdprodotto(rs.getString("idprodotto"));
				p.setCategoria(rs.getString("categoria"));
				p.setPrezzo(Double.parseDouble(rs.getString("prezzo")));
				p.setImmagine(rs.getString("immagine"));
				p.setDescrizione(rs.getString("descrizione"));
				p.setDisponibile(Integer.parseInt(rs.getString("disponibile")));
				prodotti.add(p);
			}
			return prodotti;
	}
	
	/* public ArrayList<Prodotto> doRetrieveByBrand(String mar) throws ClassNotFoundException{
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT nome, codprodotto, categoria, marca, costo, immagine, genere, quantita FROM prodotto WHERE prodotto.marca LIKE %?%");
			stmt.setString(1, "%" + mar + "%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Prodotto p = new Prodotto();
				p.setNome(rs.getString("nome"));
				p.setCodprodotto(rs.getString("codprodotto"));
				p.setCategoria(rs.getString("categoria"));
				p.setMarca(rs.getString("marca"));
				p.setCosto(Double.parseDouble(rs.getString("costo")));
				p.setImmagine(rs.getString("immagine"));
				p.setGenere(rs.getString("genere"));
				p.setQuantita(Integer.parseInt(rs.getString("quantita")));
				prodotti.add(p);
			}
			return prodotti;
		}catch(SQLException e) {
			return null;
		}
	}
	*/
	public void addProduct(String idProdotto, String nome, String categoria, float prezzo, String immagine, String descrizione, int disponibile) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO prodotto VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		stmt.setString(1, idProdotto);     
		stmt.setString(2, nome);
		stmt.setString(3, categoria);     
		stmt.setFloat(4, prezzo); 
		stmt.setString(5, immagine);     
		stmt.setString(6, descrizione); 
		stmt.setInt(7, disponibile);
		stmt.executeUpdate();
		
	}
	
	public void deleteProduct(String codProdotto) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("DELETE FROM prodotto WHERE idProdotto = ?");
		stmt.setString(1, idProdotto);
		stmt.executeUpdate();
		
	}
	
	public Prodotto getProduct(String codProdotto) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT nome, idprodotto, categoria, prezzo, immagine, descrizione, disponibile FROM prodotto WHERE idProdotto = ?");
		stmt.setString(1, codProdotto);
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				Prodotto p = new Prodotto();
				p.setNome(rs.getString("nome"));
				p.setCodprodotto(rs.getString("idprodotto"));
				p.setCategoria(rs.getString("categoria"));
				p.setPrezzo(Float.parseFloat).getString("prezzo")));
				p.setImmagine(rs.getString("immagine"));
				p.setDescrizione(rs.getString("descrizione"));
				p.setDisponibile(Integer.parseInt(rs.getString("disponibile")));
				return p;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	public void rimuoviDisponibile(String codProdotto) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("UPDATE prodotto SET disponibile = 0 WHERE idProdotto = ? AND disponibile > 0");
		stmt.setString(1, idProdotto);
		stmt.executeUpdate();
	}
	
	public ArrayList<String> getProductCodes() throws SQLException, ClassNotFoundException {
		ArrayList<String> codes = new ArrayList<String>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT idprodotto FROM prodotto");
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				String s;
				s = rs.getString("idprodotto");
				codes.add(s);
			}
			return codes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateProduct(String idProdotto, String name, String category, float price, String decription) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("UPDATE prodotto SET nome = ?, categoria = ?, prezzo = ?, descrizione = ?  WHERE idprodotto = ?");
		stmt.setString(1, name);
		stmt.setString(2, category);
		stmt.setFloat(3, price);
		stmt.setString(4, description);
		stmt.setString(5, idprodotto);
		stmt.executeUpdate();
	}
}