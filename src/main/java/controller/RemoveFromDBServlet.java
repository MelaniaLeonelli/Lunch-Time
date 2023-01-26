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

@WebServlet("/RemoveFromDBServlet")
public class RemoveFromDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromDBServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailutente");
		Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
		String pcode = request.getParameter("pcode");
		
		ProdottoDAO pDAO = new ProdottoDAO();
		try {
			pDAO.deleteProduct(pcode);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		System.out.println("Hai rimosso dal db" + pcode);
		request.setAttribute("emailutente",email);
		request.getSession().setAttribute("adminRoles", role);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminpage/removeFromDBResult.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
