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
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailutente = (String) request.getSession().getAttribute("emailutente");
		Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
		String nome = request.getParameter("cerca");
		ProdottoDAO pDAO = new ProdottoDAO();
		
		System.out.println(" DENTRO la SearchServlet il nome che dovrebbe prendersi dalla searchbar"+nome);
		
		
		ArrayList<Prodotto> a = null;
		try {
			a = pDAO.doRetrieveByName(nome);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		ArrayList<Prodotto> b = null;
		try {
			try {
				b = pDAO.doRetrieveByCategoria(nome);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		request.getSession().setAttribute("emailutente", emailutente);
	    request.getSession().setAttribute("adminRoles", role);
		request.setAttribute("nome", a);
		request.setAttribute("categoria", b);
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
