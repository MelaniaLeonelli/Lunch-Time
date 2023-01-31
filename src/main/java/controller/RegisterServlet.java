package controller;

import java.io.IOException;  
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TesseraDAO;
import model.UtenteDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("emailutente");
		String tessera = request.getParameter("codicetessera");
		UtenteDAO uDAO = new UtenteDAO();
		TesseraDAO tDAO = new TesseraDAO();
		RequestDispatcher dispatcher;
		
		try {
			if(uDAO.alreadyExist(email) || tDAO.alreadyExistT(tessera)){
				request.getSession().setAttribute("utenteEsistente", Boolean.TRUE);
				dispatcher = request.getRequestDispatcher("registerResult.jsp");
				dispatcher.forward(request, response);
			}
			
			
			else  {
				request.getSession().setAttribute("utenteEsistente", Boolean.FALSE);
				String em = request.getParameter("emailutente");
				String nomeutente = request.getParameter("nomeutente");
				String password = request.getParameter("password");
				int codicetessera = Integer.parseInt(request.getParameter("codicetessera"));
				int categoria = Integer.parseInt(request.getParameter("categoria"));
				

				
				
				System.out.println(em + nomeutente + password + codicetessera);
				try {
					uDAO.register(em, nomeutente, password);
					tDAO.addTessera(em,codicetessera,categoria);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				//uDAO.insertData(cf, address, city, cap, phone, 0);
				dispatcher = request.getRequestDispatcher("registerResult.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}