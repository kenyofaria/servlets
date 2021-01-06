package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import controller.Pages;
import dao.StudentDAO;
import entity.Student;


public class StudentListGetter implements Action{

	private HttpServletRequest req;

	public StudentListGetter(HttpServletRequest req) {
		this.req = req;
	}
	
	@Override
	public String execute() {
		List<Student> list = new StudentDAO().list();
		req.setAttribute("students", list);
		return Pages.STUDENTS.toString();
	}

}
