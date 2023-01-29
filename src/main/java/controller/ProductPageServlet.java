package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prodotto;
import model.ProdottoDAO;

@WebServlet("/ProductPageServlet")
public class ProductPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPageServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailutente = (String) request.getSession().getAttribute("emailutente");
		Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
		String pcode = request.getParameter("idcode");
		
		ProdottoDAO pDAO = new ProdottoDAO();
		Prodotto p = new Prodotto();
		try {
			p = pDAO.getProduct(pcode);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		    request.setAttribute("product", p);
		    System.out.println("il prodotto che dovrebbe passare"+p);
		    request.getSession().setAttribute("emailutente", emailutente);
		    request.getSession().setAttribute("adminRoles", role);
		RequestDispatcher dispatcher = request.getRequestDispatcher("productPage.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
