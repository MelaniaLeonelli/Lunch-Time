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

@WebServlet("/AllOrdersServlet")
public class AllOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllOrdersServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		OrdineDAO oDAO = new OrdineDAO();
		ArrayList<Ordine> o = null;
		try {
			o = oDAO.getAllOrders();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		request.setAttribute("orders", o);
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
