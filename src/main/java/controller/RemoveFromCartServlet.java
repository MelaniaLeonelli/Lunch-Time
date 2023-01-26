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

@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCartServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailutente = (String) request.getSession().getAttribute("emailutente");
		Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
		String pcode = request.getParameter("pcode");
		CarrelloDAO carrello = new CarrelloDAO();
		 
		
		ContieneDAO cDAO = new ContieneDAO();
		CarrelloDAO carrDAO = new CarrelloDAO();
		try {
			cDAO.removeFromCart(emailutente, pcode);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		System.out.println(emailutente + " ha rimosso " + pcode);
		ArrayList<Contiene> c = null;
		try {
			c = carrDAO.getCart(emailutente);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
		ArrayList<Contiene> carr = carrDAO.getCart(emailutente);
		if(c != null) {
			request.setAttribute("array", c);
			request.getSession().setAttribute("emailutente", emailutente);
			request.getSession().setAttribute("adminRoles", role);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Carrello.jsp");
			dispatcher.forward(request, response);
		}
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {

		e.printStackTrace();
	}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}