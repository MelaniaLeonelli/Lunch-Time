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

import model.Acquisto;
import model.AcquistoDAO;
import model.Prodotto;
import model.ProdottoDAO;

@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int orderCode = Integer.parseInt(request.getParameter("orderCode"));
		
		AcquistoDAO aDAO = new AcquistoDAO();
		Acquisto a = new Acquisto();
		ProdottoDAO pDAO = new ProdottoDAO();
		Prodotto p = new Prodotto();

		ArrayList<String> codes = null;
		try {
			codes = aDAO.getAcquisti(orderCode);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		
		request.setAttribute("codes", codes);
		request.setAttribute("or", orderCode);
		RequestDispatcher dispatcher = request.getRequestDispatcher("fattura.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
