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

@WebServlet("/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateServlet() {
        super();

    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pcode = request.getParameter("pcode");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		float cost = Float.parseFloat(request.getParameter("cost"));
		
		
		ProdottoDAO pDAO = new ProdottoDAO();
		Prodotto p = new Prodotto();
		
		try {
			System.out.println(pcode + name + category + cost+ description);
			pDAO.updateProduct(pcode, name, category, cost,description);
			p = pDAO.getProduct(pcode);
			System.out.println(p);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		request.setAttribute("product", p);
		RequestDispatcher dispatcher = request.getRequestDispatcher("aggiornato.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
