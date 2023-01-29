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
import model.ProdottoDAO;

@WebServlet("/AddToDBServlet")
public class AddToDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToDBServlet() {
        super();

    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idp = request.getParameter("idp");
		String name = request.getParameter("name");
		String categoria = request.getParameter("categoria");
		float prezzo = Float.parseFloat(request.getParameter("prezzo"));
		String descrizione = request.getParameter("descrizione");
		int disponibile = Integer.parseInt(request.getParameter("disponibile"));
		boolean esiste =Boolean.FALSE; 
		
		
		ProdottoDAO pDAO = new ProdottoDAO();
		
		try {
			int x=pDAO.esisteProdotto(idp);
			if(x==0) {
			
			pDAO.addProduct(idp, name, categoria, prezzo, descrizione, disponibile);
			System.out.println("Hai inserito il prodotto " + name + "(" + idp + ")" + " nel database.");
			}
			else {
				esiste=Boolean.TRUE;
			}
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		request.getSession().setAttribute("Exists", esiste);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminpage/addToDBResult.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
