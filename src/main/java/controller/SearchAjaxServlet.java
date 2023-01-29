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

import com.google.gson.Gson;

import model.Prodotto;
import model.ProdottoDAO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchAjaxServlet")
public class SearchAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAjaxServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SE MI VEDI è ENTRATO NELLA SERVLET SEARCH AJAX ");
		String emailutente = (String) request.getSession().getAttribute("emailutente");
		Boolean role = (Boolean) request.getSession().getAttribute("adminRoles");
		String nome = request.getParameter("cerca");
		System.out.println("Sono il nome nella ajax servlet "+nome);

		ProdottoDAO pDAO = new ProdottoDAO();
		ArrayList<Prodotto> a = null;
		try {
			a = pDAO.doRetrieveByName(nome);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		ArrayList<Prodotto> b = null;
		try {
			try {
				b = pDAO.doRetrieveByCategoria(nome);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		request.getSession().setAttribute("emailutente", emailutente);
	    request.getSession().setAttribute("adminRoles", role);
		request.setAttribute("nome", a);
		request.setAttribute("categoria", b);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(convertListToJson(a));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	/*private String convertListToJson(ArrayList<Prodotto> list) {
		StringBuilder s = new StringBuilder();
		s.append("[");
		for (Prodotto p : list) {
			String nome = p.getNome().replace("\"", "\\\"");
			s.append("\""+ p.getMarca() + " - " + nome + " - " + p.getCategoria() +"\",");
		}
		
		if (s.length() > 0) 
			s.setLength(s.length() - 1);
		s.append("]");
		
		
		return s.toString();
	}*/
	
	private String convertListToJson(ArrayList<Prodotto> list) {
		
		String s = new Gson().toJson(list);
		
		return s;
	}
}

