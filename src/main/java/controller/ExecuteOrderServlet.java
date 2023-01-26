package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AcquistoDAO;
import model.CarrelloDAO;
import model.Contiene;
import model.ContieneDAO;
import model.Ordine;
import model.OrdineDAO;
import model.Prodotto;
import model.ProdottoDAO;

@WebServlet("/ExecuteOrderServlet")
public class ExecuteOrderServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteOrderServlet() {
        super();

    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String emailutente = (String) request.getSession().getAttribute("emailutente");
	Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
    int latest = 0;
    double tot = 0;
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    CarrelloDAO cDAO = new CarrelloDAO();
    OrdineDAO oDAO = new OrdineDAO();
    ContieneDAO coDAO = new ContieneDAO();
    AcquistoDAO aDAO = new AcquistoDAO();
    ProdottoDAO pDAO = new ProdottoDAO();

    ArrayList<Contiene> cart = new ArrayList<Contiene>();
    try {
      cart = cDAO.getCart(emailutente);
    } catch (ClassNotFoundException e) {

      e.printStackTrace();
    } catch (SQLException e) {

      e.printStackTrace();
    }
    try {
      tot = coDAO.getTotal(emailutente);
    } catch (ClassNotFoundException | SQLException e) {

      e.printStackTrace();
    }
    try {
      latest = oDAO.getLatestOrder();
    } catch (ClassNotFoundException | SQLException e) {

      e.printStackTrace();
    }
    latest++;
    System.out.println("codice ordine"+latest);
    
    try {
    	int x=aDAO.verificaSaldo(tot, emailutente);
    	if(x==1) {
      oDAO.order(latest, emailutente, date.format(formatterDate), tot);
      aDAO.effettuaPagamento(tot, emailutente);
    	}
    	if(x==0){
    		request.getSession().setAttribute("emailutente", emailutente);
    		request.getSession().setAttribute("adminRoles", role);
    	    RequestDispatcher dispatcher = request.getRequestDispatcher("saldoinsufficiente.jsp");
    	    dispatcher.forward(request, response);
    		
    	}
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    
    int i = 0;
    while(i < cart.size()) {
      int cod = latest;
      double prezzo;
      Prodotto p = new Prodotto();
      try {
        p = pDAO.getProduct(cart.get(i).getIdprodotto());
      } catch (ClassNotFoundException | SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      prezzo = p.getPrezzo();
      System.out.println(prezzo);
      try {
        aDAO.addAcquisto(cod, cart.get(i).getIdprodotto(), prezzo);
      } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
      }
      i++;
    }
    
  
    try {
      cDAO.emptyBasket(emailutente);
    } catch (ClassNotFoundException | SQLException e) {

      e.printStackTrace();
    }
    
    Ordine o = new Ordine();
    try {
      o = oDAO.getOrderByCode(latest);
    } catch (ClassNotFoundException e) {

      e.printStackTrace();
    }
    
    System.out.println(emailutente + "ha effettuato l'ordine" + latest);
    
    request.setAttribute("CodOrdine", o);
    request.getSession().setAttribute("emailutente", emailutente);
	request.getSession().setAttribute("adminRoles", role);
    RequestDispatcher dispatcher = request.getRequestDispatcher("ordineeffettuato.jsp");
    dispatcher.forward(request, response);
  }
  
  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    doGet(request, response);
  }

}