package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.StudentListGetter;
import controller.action.StudentLoader;
import controller.action.StudentPersister;
import controller.action.StudentRemover;

@WebServlet(urlPatterns = "/students")
public class StudentServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		String registerNumber = req.getParameter("registerNumber");
		
		if(operation!=null) {
			if(operation.equals("edit")) {
				if(registerNumber!=null) {
					String page = new StudentLoader(req).execute();
					RequestDispatcher dispatcher = req.getRequestDispatcher(page);
					dispatcher.forward(req, resp);
				}
			}
			if(operation.equals("delete")) {
				if(registerNumber!=null) {
					String page = new StudentRemover(req).execute();
					RequestDispatcher dispatcher = req.getRequestDispatcher(page);
					dispatcher.forward(req, resp);
				}
			}
		}else {
			String page = new StudentListGetter(req).execute();
			RequestDispatcher dispatcher = req.getRequestDispatcher(page);
			dispatcher.forward(req, resp);
		}
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = new StudentPersister(req).execute();
		RequestDispatcher dispatcher = req.getRequestDispatcher(page);
		dispatcher.forward(req, resp);
	}
}
