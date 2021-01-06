package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private String registerNumber;
	private String name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String registerNumber, String name) {
		super();
		this.registerNumber = registerNumber;
		this.name = name;
	}

	
	public Student(String registerNumber) {
		super();
		this.registerNumber = registerNumber;
	}


	public String getRegisterNumber() {
		return registerNumber;
	}

	public String getName() {
		return name;
	}


	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
}
