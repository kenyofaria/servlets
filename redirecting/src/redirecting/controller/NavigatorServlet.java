package redirecting.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/go")
public class NavigatorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("pag");
		if (page != null) {
			if (page.equals("page1")) {
				//redirecionamento client side
				resp.sendRedirect("page1.jsp");
			}
			if (page.equals("page2")) {
				//redirecionamento server side
				RequestDispatcher dispatcher = req.getRequestDispatcher("page2.jsp");
				dispatcher.forward(req, resp);
			}
		}else {
			//redirecionamento client side
			resp.sendRedirect("login.jsp");
		}
	}
}
