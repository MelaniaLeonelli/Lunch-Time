
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

import model.Preferisce;
import model.PreferisceDAO;
import model.Prodotto;
import model.ProdottoDAO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchbyPreferitiServlet")
public class SearchbyPreferitiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchbyPreferitiServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailutente = request.getParameter("emailutente");
		ProdottoDAO pDAO = new ProdottoDAO();
		Prodotto a = null;
		try {
			a = pDAO.getPreferisce("emailutente");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		System.out.println("a:" + a);
		request.setAttribute("emailutente", a);
		RequestDispatcher dispatcher = request.getRequestDispatcher("resultsPreferiti.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
