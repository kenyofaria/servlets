package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entity.Student;

public class StudentDAO {
	
	private JPAUtil jpaUtil;
	private EntityManager em;

	
	public StudentDAO() {
		jpaUtil = new JPAUtil();
		em = jpaUtil.getEntityManager();
	}
	
	public void salva(Student student) {
		em.getTransaction().begin();
		Student existingStudent = get(student.getRegisterNumber());
		if(existingStudent == null) {
			em.persist(student);
		}else {
			existingStudent.setRegisterNumber(student.getRegisterNumber());
			existingStudent.setName(student.getName());
			em.persist(existingStudent);
		}
		em.getTransaction().commit();
	}

	public List<Student> list() {
		TypedQuery<Student> qry = em.createQuery("from Student", Student.class);
		List<Student> resultList = qry.getResultList();
		return resultList;
	}

	public void delete(Student student) {
		em.getTransaction().begin();
		student = em.find(Student.class, student.getRegisterNumber());
		em.remove(student);
		em.getTransaction().commit();
	}

	public Student get(String registerNumber) {
		Student student = em.find(Student.class, registerNumber);
		return student;
	}

}
