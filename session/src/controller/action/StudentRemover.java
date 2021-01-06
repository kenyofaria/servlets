package controller.action;

import javax.servlet.http.HttpServletRequest;

import dao.StudentDAO;
import entity.Student;


public class StudentRemover implements Action{

	private HttpServletRequest req;

	public StudentRemover(HttpServletRequest req) {
		this.req = req;
	}
	
	@Override
	public String execute() {
		String registerNumber = req.getParameter("registerNumber");
		new StudentDAO().delete(new Student(registerNumber));
		String page = new StudentListGetter(req).execute();
		return page;
	}

}
