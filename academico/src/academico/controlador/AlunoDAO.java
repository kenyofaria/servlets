package academico.controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import academico.entidade.Aluno;
import academico.jpa.util.JPAUtil;

public class AlunoDAO {

	private JPAUtil jpaUtil;
	private EntityManager em;

	public AlunoDAO() {
		jpaUtil = new JPAUtil();
		em = jpaUtil.getEntityManager();
	}
	
	public void salva(Aluno aluno) {
		em.getTransaction().begin();
		Aluno existente = get(aluno.getMatricula());
		if(existente == null) {
			em.persist(aluno);
		}else {
			existente.setMatricula(aluno.getMatricula());
			existente.setNome(aluno.getNome());
			em.persist(existente);
		}
		em.getTransaction().commit();
	}


	public void deleta(Aluno aluno) {
		em.getTransaction().begin();
		aluno = em.find(Aluno.class, aluno.getMatricula());
		em.remove(aluno);
		em.getTransaction().commit();
	}

	public List<Aluno> lista() {
		TypedQuery<Aluno> qry = em.createQuery("from Aluno", Aluno.class);
		return qry.getResultList();
	}

	public Aluno get(String matricula) {
		return em.find(Aluno.class, matricula);
	}
}
