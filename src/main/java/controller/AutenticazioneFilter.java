package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutenticazioneFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		
		String loginURI = hrequest.getContextPath() + "/adminpage";
		boolean loginRequest = hrequest.getRequestURI().startsWith(loginURI);

		if(loginRequest) {
			System.out.println("Check role in the session");
			//check the token from session
			HttpSession session = hrequest.getSession(false);
			boolean admin = session != null && session.getAttribute("adminRoles") == Boolean.TRUE;

			if(!admin) {
				System.out.println("Redirect to homepage");
				hresponse.sendRedirect(hrequest.getContextPath()+ "/index.jsp");
			} else {
				// admin resource
				chain.doFilter(request, response);
			}
		} else {
			// accessible resource
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Init the filter");
	}

}
