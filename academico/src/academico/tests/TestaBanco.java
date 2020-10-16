package academico.tests;

import javax.persistence.EntityManager;

import academico.entidade.Aluno;
import academico.jpa.util.JPAUtil;

public class TestaBanco {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(new Aluno("222", "Joao Vitor"));
		em.getTransaction().commit();
	}
}
