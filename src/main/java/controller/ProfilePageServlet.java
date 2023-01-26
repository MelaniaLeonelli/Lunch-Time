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

import model.Utente;
import model.UtenteDAO;
import model.Tessera;
import model.TesseraDAO;

@WebServlet("/ProfilePageServlet")
public class ProfilePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilePageServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String em = (String) request.getSession().getAttribute("emailutente");
		Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
		UtenteDAO uDAO = new UtenteDAO();
		Utente u = new Utente();
		TesseraDAO tDAO = new TesseraDAO();
		Tessera t = new Tessera();

		try {
			u = uDAO.getUserDatabyEmail(em);
			t= tDAO.getTesseraData(em);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		request.getSession().setAttribute("adminRoles", role);
		request.getSession().setAttribute("emailutente", em);
		request.getSession().setAttribute("nomeutente", u.getNomeutente());
		request.getSession().setAttribute("ruolo", u.getRuolo());
		request.getSession().setAttribute("codtessera", t.getCodicetessera());
		request.getSession().setAttribute("cattessera", t.getCategoria());
		request.getSession().setAttribute("saldo", t.getSaldo());
		System.out.println("nella servlet");
		System.out.println(t.getCategoria());
		System.out.println("nella servlet");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProfilePage.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
