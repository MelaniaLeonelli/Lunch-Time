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

import model.Prodotto;
import model.ProdottoDAO;
import model.Utente;
import model.UtenteDAO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/MenuDGServlet")
public class MenuDGServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuDGServlet() {
        super();

    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String emailutente = (String) request.getSession().getAttribute("emailutente");
	
    ProdottoDAO pDAO = new ProdottoDAO();
    ArrayList<Prodotto> a = null;
    try {
      a = pDAO.getMenuDG();
    } catch (ClassNotFoundException | SQLException e) {

      e.printStackTrace();
    }
    request.getSession().setAttribute("emailutente", emailutente);
    request.setAttribute("array", a);
    RequestDispatcher dispatcher = request.getRequestDispatcher("MenuDG.jsp");
    dispatcher.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    doGet(request, response);
  }

}