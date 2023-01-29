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

@WebServlet("/RemovePreferitiServlet")
public class RemovePreferitiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemovePreferitiServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailutente = request.getParameter("emailutente");
		String pcode = request.getParameter("pcode");
		Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
		
		
		PreferisceDAO pDAO = new PreferisceDAO();
		try {
			
			pDAO.deletePreferito(pcode, emailutente);
			System.out.println(emailutente + " ha eliminato il prodotto" + pcode + "dai preferiti.");
			
				
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		request.getSession().setAttribute("emailutente", emailutente);
		request.getSession().setAttribute("adminRoles", role);
		RequestDispatcher dispatcher = request.getRequestDispatcher("RemovePreferitiResult.jsp");
		dispatcher.forward(request, response);
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
