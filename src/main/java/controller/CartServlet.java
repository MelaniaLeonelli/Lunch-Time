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

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailutente = (String) request.getSession().getAttribute("emailutente");
		Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
		
		CarrelloDAO carrDAO = new CarrelloDAO();
		try {
			ArrayList<Contiene> c = carrDAO.getCart(emailutente);
			if(c != null) {
				System.out.println("carrello: " + c);
				request.setAttribute("array", c);
				request.getSession().setAttribute("emailutente", emailutente);
				request.getSession().setAttribute("adminRoles", role);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Carrello.jsp");
				dispatcher.forward(request, response);
			}
			else System.out.println("errore carrello");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}
	
	/**d
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
