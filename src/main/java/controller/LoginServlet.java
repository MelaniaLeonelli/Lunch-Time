package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import model.Tessera;
>>>>>>> b5f171113ed8691351bdd32889e44f1258214da2
=======
import model.Tessera;
>>>>>>> e1c0f993aa4f69713ab4375caa5dd025c631b829
import model.Utente;
import model.UtenteDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailutente = request.getParameter("emailutente");
		String password = request.getParameter("password");
		
		System.out.println(emailutente + ", " + password);
		UtenteDAO uDAO = new UtenteDAO();
		RequestDispatcher dispatcher;
		
				try 
				{
					if (uDAO.login(emailutente, password) == 1)
					{
						request.getSession().setAttribute("ruolo", Boolean.TRUE);
						request.getSession().setAttribute("emailutente", emailutente);
						Utente u = uDAO.getUserData(emailutente, password);
						request.getSession().setAttribute("nomeutente", u.getNomeutente());
						dispatcher = request.getRequestDispatcher("index.jsp");
						dispatcher.forward(request, response);
					}
					
					else if(uDAO.login(emailutente, password) == 2)
					{
						request.getSession().setAttribute("ruolo", Boolean.FALSE);
						request.getSession().setAttribute("emailutente", emailutente);
						Utente u = uDAO.getUserData(emailutente, password);
						request.getSession().setAttribute("nomeutente", u.getNomeutente());
						dispatcher = request.getRequestDispatcher("index.jsp");
						dispatcher.forward(request, response);
					}
					
					else if(uDAO.login(emailutente, password) == 3)
					{
						request.getSession().setAttribute("nonRegistrato", Boolean.TRUE);
						dispatcher = request.getRequestDispatcher("loginResult.jsp");
						dispatcher.forward(request, response);
					}
					
					
			  }catch (ClassNotFoundException | SQLException | ServletException | IOException e) 
			   {
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
