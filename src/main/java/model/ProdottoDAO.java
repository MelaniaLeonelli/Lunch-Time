package model;
import java.sql.*;
import java.util.ArrayList;

import controller.DriverManagerConnectionPool;

public class ProdottoDAO {
  
  public static String URL = "jdbc:mysql://localhost:3306/lunchtime";
  public static String USER = "root";
  public static String PASS = "password";
  
  public ArrayList<Prodotto> doRetrieveByName(String nome) throws ClassNotFoundException{
    ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(URL, USER, PASS);
      PreparedStatement stmt;
      stmt = con.prepareStatement("SELECT nome, idprodotto, categoria, prezzo, descrizione FROM prodotto WHERE prodotto.nome LIKE ?");
      stmt.setString(1, "%" + nome + "%");
      ResultSet rs = stmt.executeQuery();
      while(rs.next()) {
        Prodotto p = new Prodotto();
        p.setIdprodotto(rs.getString("idprodotto"));
        p.setNome(rs.getString("nome"));
        p.setCategoria(rs.getString("categoria"));
        p.setPrezzo(Float.parseFloat(rs.getString("prezzo")));
        p.setDescrizione(rs.getString("descrizione"));
        prodotti.add(p);
      }
      return prodotti;
    }catch(SQLException e) {
      return null;
    }
  }
 
  public ArrayList<Prodotto> doRetrieveByCategoria(String cat) throws ClassNotFoundException, SQLException{
    ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
    Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(URL, USER, PASS);
      PreparedStatement stmt;
      stmt = con.prepareStatement("SELECT nome, idprodotto, categoria, prezzo, descrizione FROM prodotto WHERE prodotto.categoria LIKE ?");
      stmt.setString(1, "%" + cat + "%");
      ResultSet rs = stmt.executeQuery();
      while(rs.next()) {
        Prodotto p = new Prodotto();
        p.setIdprodotto(rs.getString("idprodotto"));
        p.setNome(rs.getString("nome"));
        p.setCategoria(rs.getString("categoria"));
        p.setPrezzo(Float.parseFloat(rs.getString("prezzo")));
        p.setDescrizione(rs.getString("descrizione"));
        prodotti.add(p);
      }
      return prodotti;
  }
  
  
  public void addProduct(String idProdotto, String nome, String categoria, float prezzo,  String descrizione, int disponibile) throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(URL, USER, PASS);
    PreparedStatement stmt;
    stmt = con.prepareStatement("INSERT INTO prodotto VALUES (?, ?, ?, ?, ?, ?)");
    stmt.setString(1, idProdotto);     
    stmt.setString(2, nome);
    stmt.setString(3, categoria);     
    stmt.setFloat(4, prezzo);     
    stmt.setString(5, descrizione); 
    stmt.setInt(6, disponibile);
    stmt.executeUpdate();
    
  }
  
  public void deleteProduct(String idProdotto) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(URL, USER, PASS);
    PreparedStatement stmt;
    stmt = con.prepareStatement("DELETE FROM prodotto WHERE idProdotto = ?");
    stmt.setString(1, idProdotto);
    stmt.executeUpdate();
    
  }
  
  public Prodotto getProduct(String idProdotto) throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(URL, USER, PASS);
    PreparedStatement stmt;
    stmt = con.prepareStatement("SELECT nome, idprodotto, categoria, prezzo, descrizione, disponibile FROM prodotto WHERE idProdotto = ?");
    stmt.setString(1, idProdotto);
    ResultSet rs = stmt.executeQuery();
    try {
    	while(rs.next()) {
            Prodotto p = new Prodotto();
            p.setNome(rs.getString("nome"));
            p.setIdprodotto(rs.getString("idprodotto"));
            p.setCategoria(rs.getString("categoria"));
            p.setPrezzo(Float.parseFloat(rs.getString("prezzo")));
            p.setDescrizione(rs.getString("descrizione"));
            p.setDisponibile(Integer.parseInt(rs.getString("disponibile")));
            return p;
          }
          
        } catch (SQLException e) {

          e.printStackTrace();
        }
        return null;
      }
      
      public void rimuoviDisponibile(String idProdotto) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement stmt;
        stmt = con.prepareStatement("UPDATE prodotto SET disponibile = 0 WHERE idProdotto = ? AND disponibile > 0");
        stmt.setString(1, idProdotto);
        stmt.executeUpdate();
      }
      
      public ArrayList<String> getProductCodes() throws SQLException, ClassNotFoundException {
        ArrayList<String> codes = new ArrayList<String>();
        Class.forName("com.mysql.cj.jdbc.Driver");
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
      
      public void updateProduct(String idProdotto, String name, String category, float price, String description, int disponibile) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement stmt;
        stmt = con.prepareStatement("UPDATE prodotto SET nome = ?, categoria = ?, prezzo = ?, descrizione = ?, disponibile= ?  WHERE idprodotto = ?");
        stmt.setString(1, name);
        stmt.setString(2, category);
        stmt.setFloat(3, price);
        stmt.setString(4, description);
        stmt.setInt(5, disponibile);
        stmt.setString(6, idProdotto);
        stmt.executeUpdate();
      }
      public ArrayList<Prodotto> getPreferisce(ArrayList<Preferisce> a,String em) throws SQLException, ClassNotFoundException {
    	    ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    Connection con = DriverManager.getConnection(URL, USER, PASS);
    	    PreparedStatement stmt;  
    	        int i=0;
    	    
    	      while(i<a.size()) {
    	        stmt = con.prepareStatement("SELECT  IdProdotto, nome, descrizione FROM prodotto WHERE prodotto.idprodotto =? ");
    	        Preferisce ale=a.get(i);
    	        String s =ale.getIdprodotto();
    	        System.out.println(a.size());
    	        stmt.setString(1,s);
    	        ResultSet rs = stmt.executeQuery();
    	        Prodotto p = new Prodotto();
    	        rs.next();
    	        p.setNome(rs.getString("nome"));
    	        p.setDescrizione(rs.getString("descrizione"));
    	        p.setIdprodotto(rs.getString("IdProdotto"));
    	        
    	         prodotti.add(p);
    	         i++;
    	        
    	      }return prodotti;
    	  }
    	  public ArrayList<Prodotto> getAllProducts() throws ClassNotFoundException, SQLException{
    	      ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
    	        Class.forName("com.mysql.cj.jdbc.Driver");
    	        Connection con = DriverManager.getConnection(URL, USER, PASS);
    	        PreparedStatement stmt;
    	        stmt = con.prepareStatement("SELECT nome, idprodotto, categoria, prezzo,  descrizione, disponibile FROM prodotto");
    	        ResultSet rs = stmt.executeQuery();
    	        while(rs.next()) {
    	          Prodotto p = new Prodotto();
    	          p.setIdprodotto(rs.getString("idprodotto"));
    	          p.setNome(rs.getString("nome"));
    	          p.setCategoria(rs.getString("categoria"));
    	          p.setPrezzo(Float.parseFloat(rs.getString("prezzo")));
    	          p.setDescrizione(rs.getString("descrizione"));
    	          p.setDisponibile(Integer.parseInt(rs.getString("disponibile")));
    	          prodotti.add(p);
    	        
    	        }
    	        return prodotti;
    	       
    	    }
    	  
    	  public ArrayList<Prodotto> getMenuDG() throws SQLException, ClassNotFoundException {
    			ArrayList<Prodotto> disponibili = new ArrayList<Prodotto>();
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			Connection con = DriverManager.getConnection(URL, USER, PASS);
    			PreparedStatement stmt;	
    			stmt = con.prepareStatement("SELECT * FROM prodotto WHERE disponibile=1");
    			
    			ResultSet rs = stmt.executeQuery();
    			while(rs.next()) {
    				Prodotto s=new Prodotto();
    				s.setNome(rs.getString("nome"));
    				s.setIdprodotto(rs.getString("idprodotto"));
    				s.setPrezzo(Float.parseFloat(rs.getString("prezzo")));
    				disponibili.add(s);
    					
    				}return disponibili;
    		
    		}
    	  
    	  public int esisteProdotto(String IdProdotto) throws ClassNotFoundException, SQLException{
    		  Class.forName("com.mysql.cj.jdbc.Driver");
    		    Connection con = DriverManager.getConnection(URL, USER, PASS);
    		    PreparedStatement stmt;
    		    stmt = con.prepareStatement("SELECT IdProdotto FROM prodotto WHERE IdProdotto=?");
    		    stmt.setString(1, IdProdotto);
    		    ResultSet rs =stmt.executeQuery();
    		    int check=0;
    		    while(rs.next()) {
    		        Preferisce p = new Preferisce();
    		        p.setIdprodotto(rs.getString("IdProdotto"));
    		        System.out.println("db"+p.getIdprodotto()+"parametro"+IdProdotto);
    		        if((p.getIdprodotto()).equals(IdProdotto)) 
    		        {
    		        	check=1;
    		        }
    		    }
    		    System.out.println("sono io il check adesso:"+check);
    		    return check;
    		        
    	  }
    	}
    