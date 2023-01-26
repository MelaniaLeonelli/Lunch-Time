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

/**
 * Servlet implementation class SvuotaCestino
 */
@WebServlet("/SvuotaCestinoServlet")
public class SvuotaCestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvuotaCestinoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailutente = (String) request.getSession().getAttribute("emailutente");
		Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
		CarrelloDAO carrello = new CarrelloDAO();
		 
		
		ContieneDAO cDAO = new ContieneDAO();
		CarrelloDAO carrDAO = new CarrelloDAO();
		try {
			cDAO.cleanCart(emailutente);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		System.out.println(emailutente + " ha svuotato il carrello");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
