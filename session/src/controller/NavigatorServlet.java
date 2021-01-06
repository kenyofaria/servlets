package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.StudentListGetter;
import controller.action.UserAuthenticator;

@WebServlet(urlPatterns = "/go")
public class NavigatorServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String pageToGo = "login.jsp";

		if(isSessionOpen(req)) {
			if (page != null) {
				if (page.equals("students")) {
					pageToGo = new StudentListGetter(req).execute();
				}
				if (page.equals("student-form")) {
					pageToGo = "student-form.jsp";
				}
			}
			
		}else {
			pageToGo = new UserAuthenticator(req).execute();
		}
		req.getRequestDispatcher(pageToGo).forward(req, resp);
	}
	
	private boolean isSessionOpen(HttpServletRequest req) {
		return req.getSession().getAttribute("authenticatedUser")!=null;
	}
}
