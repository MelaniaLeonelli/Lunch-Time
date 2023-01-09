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

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idprodotto = request.getParameter("idprodotto");
		String emailutente = request.getParameter("em");
		
		System.out.println(emailutente + " ha inserito il prodotto" + idprodotto + "nel carrello.");
		ContieneDAO cDAO = new ContieneDAO();
		CarrelloDAO carrDAO = new CarrelloDAO();
		Prodotto p = new Prodotto();
		ProdottoDAO pDAO = new ProdottoDAO();
		
		try {
			p = pDAO.getProduct(idprodotto);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			cDAO.addToCart(emailutente, idprodotto, 1, p.getPrezzo());
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		ArrayList<Contiene> c = null;

		try {
			c = carrDAO.getCart(emailutente);
			System.out.println("Carrello di " + emailutente + ":" + c);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		request.setAttribute("em", c);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
