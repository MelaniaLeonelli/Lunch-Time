package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarrelloDAO;
import model.Contiene;
import model.ContieneDAO;

import model.Prodotto;
import model.ProdottoDAO;
import model.Utente;
import model.UtenteDAO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/CatalogoServlet")
public class CatalogoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogoServlet() {
        super();

    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String emailutente = (String) request.getSession().getAttribute("emailutente");
	  Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
	
    ProdottoDAO pDAO = new ProdottoDAO();
    ArrayList<Prodotto> a = null;
    try {
      a = pDAO.getAllProducts();
    } catch (ClassNotFoundException | SQLException e) {

      e.printStackTrace();
    }
    request.getSession().setAttribute("emailutente", emailutente);
    request.getSession().setAttribute("adminRoles", role);
    request.setAttribute("array", a);
    RequestDispatcher dispatcher = request.getRequestDispatcher("Catalogo.jsp");
    dispatcher.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    doGet(request, response);
  }

}