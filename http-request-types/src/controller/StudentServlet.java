package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.StudentDAO;
import entity.Student;

@WebServlet(urlPatterns="/students")
public class StudentServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String registerNumber = req.getParameter("register-number-input");
		String name = req.getParameter("name-input");
		
		Student student = new Student(registerNumber, name);
		StudentDAO dao = new StudentDAO();
		dao.salva(student);
		resp.sendRedirect("students.html");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO studentDAO = new StudentDAO();
		
		Gson gson = new Gson();
		
		String registerNumber = req.getParameter("registerNumber");
		if(registerNumber==null) {
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(gson.toJson(studentDAO.list()));
		}else {
			
			String operation = req.getParameter("operation");
			
			if(operation != null && operation.equals("delete")) {
				studentDAO.delete(new Student(registerNumber));
				resp.sendRedirect("students.html");
			}else {
				
				if(req.getParameter("source")!=null && req.getParameter("source").equals("student-form")) {
					String studentJson = gson.toJson(studentDAO.get(registerNumber));
					resp.setContentType("application/json");
					resp.getWriter().print(studentJson.toString());
				}else {
					resp.sendRedirect("student-form.html?registerNumber="+req.getParameter("registerNumber"));
				}
			}
		}
		
		
	}
}