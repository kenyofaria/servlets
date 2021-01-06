package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import entity.Student;

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
					Student student = new StudentDAO().get(registerNumber);
					req.setAttribute("student", student);
					RequestDispatcher dispatcher = req.getRequestDispatcher("student-form.jsp");
					dispatcher.forward(req, resp);
				}
			}
			if(operation.equals("delete")) {
				if(registerNumber!=null) {
					Student student = new Student(registerNumber);
					new StudentDAO().delete(student);
					dispatchToStudentList(req,resp);
				}
			}
		}else {
			dispatchToStudentList(req,resp);
		}
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String registerNumber = req.getParameter("register-number-input");
		String name = req.getParameter("name-input");
		
		Student student = new Student(registerNumber, name);
		StudentDAO dao = new StudentDAO();
		dao.salva(student);
		
		dispatchToStudentList(req, resp);
	}
	
	private void dispatchToStudentList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		List<Student> students = dao.list();
		req.setAttribute("students", students);
		RequestDispatcher dispatcher = req.getRequestDispatcher("students.jsp");
		dispatcher.forward(req, resp);
	}
}
