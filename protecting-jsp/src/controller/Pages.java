package controller;

public enum Pages {
	LOGIN("WEB-INF/view/login.jsp"),
	DASHBOARD("WEB-INF/view/dashboard.jsp"),
	STUDENTS("WEB-INF/view/students.jsp"),
	STUDETN_FORM("WEB-INF/view/student-form.jsp");
	
	private String value;
	
	Pages(String s) {
		this.value = s;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
}
