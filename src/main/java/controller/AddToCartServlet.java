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
		
		String emailutente = request.getParameter("emailutente");
		String pcode = request.getParameter("pcode");
		Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
		
		System.out.println(emailutente + " ha inserito il prodotto" + pcode + "nel carrello.");
		ContieneDAO cDAO = new ContieneDAO();
		CarrelloDAO carrDAO = new CarrelloDAO();
		Prodotto p = new Prodotto();
		ProdottoDAO pDAO = new ProdottoDAO();
		
		try {
			p = pDAO.getProduct(pcode);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			cDAO.addToCart(emailutente, pcode, 1, p.getPrezzo());
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		ArrayList<Contiene> c = null;System.out.println("contiene array creato");

		try {
			c = carrDAO.getCart(emailutente);System.out.println("carrello  creato");
			System.out.println("Carrello di " + emailutente + ":" + c);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println(emailutente+"servlet del carrello");
		request.getSession().setAttribute("emailutente", emailutente);
		request.getSession().setAttribute("pcode", pcode);System.out.println(emailutente+"prima del dispatcher");
		RequestDispatcher dispatcher = request.getRequestDispatcher("CartServlet");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
