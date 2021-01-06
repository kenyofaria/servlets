package controller.acition;

import javax.servlet.http.HttpServletRequest;

import dao.StudentDAO;
import entity.Student;


public class StudentPersister implements Action{

	private HttpServletRequest req;
	public StudentPersister(HttpServletRequest req) {
		this.req = req;
	}
	
	@Override
	public String execute() {
		String registerNumber = req.getParameter("register-number-input");
		String name = req.getParameter("name-input");
		Student student = new Student(registerNumber, name);
		new StudentDAO().salva(student);
		
		String pageToGo = new StudentListGetter(req).execute();
		return pageToGo;
	}

}
