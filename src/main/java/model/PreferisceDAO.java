package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DriverManagerConnectionPool;

public class PreferisceDAO {
  
  public static String URL = "jdbc:mysql://localhost:3306/lunchtime";
  public static String USER = "root";
  public static String PASS = "password";

  public void addPreferito(String IdProdotto, String em) throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(URL, USER, PASS);
    PreparedStatement stmt;
    stmt = con.prepareStatement("INSERT INTO preferisce VALUES(?, ?)");
    stmt.setString(1, IdProdotto);
    stmt.setString(2, em);
    stmt.executeUpdate();
  }
  public int checkPreferito(String IdProdotto,String em) throws ClassNotFoundException, SQLException{
	  Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection(URL, USER, PASS);
	    PreparedStatement stmt;
	    stmt = con.prepareStatement("SELECT IdProdotto FROM preferisce WHERE emailutente=? AND IdProdotto=?");
	    stmt.setString(1,em);
	    stmt.setString(2, IdProdotto);
	    ResultSet rs =stmt.executeQuery();
	    int check=0;System.out.println("prima del while");
	    while(rs.next()) {System.out.println("appena entrato nel while");
	        Preferisce p = new Preferisce();System.out.println("prima del set");
	        p.setIdprodotto(rs.getString("IdProdotto"));
	        p.setEmailutente(em);
	        System.out.println("db"+p.getIdprodotto()+"parametro"+IdProdotto);
	        if((p.getIdprodotto()).equals(IdProdotto)) 
	        {System.out.println("se mi vedi il check è partito");
	        	check=1;
	        }
	    }
	    System.out.println("sono io il check adesso:"+check);
	    return check;
	        
  }
  public void deletePreferito(String IdProdotto, String em) throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(URL, USER, PASS);
    PreparedStatement stmt;
    stmt = con.prepareStatement("DELETE INTO preferisce VALUES(?, ?)");
    stmt.setString(1, IdProdotto);
    stmt.setString(2, em);
    stmt.executeUpdate();
  }
  public ArrayList<Preferisce> getPreferiti(String em) throws SQLException, ClassNotFoundException {
    ArrayList<Preferisce> preferiti = new ArrayList<Preferisce>();
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(URL, USER, PASS);
    PreparedStatement stmt;  
    stmt = con.prepareStatement("SELECT IdProdotto FROM  preferisce WHERE emailutente=?");
    stmt.setString(1, em);
    ResultSet rs = stmt.executeQuery();
      while(rs.next()) {
        Preferisce p = new Preferisce();
        p.setIdprodotto(rs.getString("IdProdotto"));
        p.setEmailutente(em);
         preferiti.add(p);
         System.out.println(preferiti);

        
      }return preferiti;
  
  }  

}