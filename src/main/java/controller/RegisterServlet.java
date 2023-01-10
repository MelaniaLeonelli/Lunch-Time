package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InfoUtenteDAO;
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
		
		String email = request.getParameter("email");
		UtenteDAO uDAO = new UtenteDAO();
		RequestDispatcher dispatcher;
		
		try {
			if(uDAO.alreadyExist(email)){
				request.getSession().setAttribute("utenteEsistente", Boolean.TRUE);
				dispatcher = request.getRequestDispatcher("registerResult.jsp");
				dispatcher.forward(request, response);
			}
			else {
				request.getSession().setAttribute("utenteEsistente", Boolean.FALSE);
				String cf = request.getParameter("cf");
				String surname = request.getParameter("surname");
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String address = request.getParameter("address");
				String city = request.getParameter("city");
				String cap = request.getParameter("cap");
				String phone = request.getParameter("phone");

				InfoUtenteDAO iuDAO = new InfoUtenteDAO();
				
				System.out.println(cf + surname + name + email + password);
				try {
					uDAO.register(cf, surname, name, email, password);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				iuDAO.insertData(cf, address, city, cap, phone, 0);
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