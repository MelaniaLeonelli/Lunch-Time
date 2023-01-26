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

import model.Ordine;
import model.TesseraDAO;

@WebServlet("/UpdateBalanceServlet")
public class UpdateBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBalanceServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("emailutente");
		Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
		int codicetessera = Integer.parseInt(request.getParameter("codicetessera"));
		int value = Integer.parseInt(request.getParameter("ricarica"));
		System.out.println("il codice tessera è:");
		System.out.println(codicetessera);
		TesseraDAO tDAO = new TesseraDAO();
		
		
					  try {
				try {
					tDAO.ricaricaTessera(codicetessera,value);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		request.setAttribute("emailutente",email);
		request.setAttribute("ricarica",value);
		request.getSession().setAttribute("adminRoles", role);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("BalanceResult.jsp");
		dispatcher.forward(request, response);
	}
	
	/**d
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
