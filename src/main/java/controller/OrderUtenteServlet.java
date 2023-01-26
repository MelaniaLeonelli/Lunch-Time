package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ordine;
import model.OrdineDAO;

@WebServlet("/OrderUtenteServlet")
public class OrderUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderUtenteServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailutente = (String) request.getSession().getAttribute("emailutente");
		Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
		OrdineDAO oDAO = new OrdineDAO();
		ArrayList<Ordine> o = null;
		try {
			o = oDAO.getOrdersUtente(emailutente);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		request.setAttribute("orders", o);
		request.getSession().setAttribute("emailutente", emailutente);
		request.getSession().setAttribute("adminRoles", role);
		RequestDispatcher dispatcher = request.getRequestDispatcher("allOrders.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
