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

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchbyCategoryServlet")
public class SearchbyCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchbyCategoryServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoria = request.getParameter("categoria");
		ProdottoDAO pDAO = new ProdottoDAO();
		Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
		ArrayList<Prodotto> a = null;
		try {
			a = pDAO.doRetrieveByCategoria(categoria);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		System.out.println("a:" + a);
		request.setAttribute("categoria", a);
		request.getSession().setAttribute("adminRoles", role);
		RequestDispatcher dispatcher = request.getRequestDispatcher("resultsCategoria.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
