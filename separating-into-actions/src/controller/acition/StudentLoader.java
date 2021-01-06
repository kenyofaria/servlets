package controller.acition;

import javax.servlet.http.HttpServletRequest;

import dao.StudentDAO;
import entity.Student;


public class StudentLoader implements Action{

	private HttpServletRequest req;
	
	public StudentLoader(HttpServletRequest req) {
		this.req = req;
	}
	
	@Override
	public String execute() {
		String registerNumber = req.getParameter("registerNumber");
		Student student = new StudentDAO().get(registerNumber);
		req.setAttribute("student", student);
		return "student-form.jsp";
	}

}
