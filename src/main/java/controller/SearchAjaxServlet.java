package controller;

import java.io.IOException;
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
		
		String nome = request.getParameter("cerca");
		ProdottoDAO pDAO = new ProdottoDAO();
		ArrayList<Prodotto> a = null;
		try {
			a = pDAO.doRetrieveByName(nome);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
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

