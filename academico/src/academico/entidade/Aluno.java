package academico.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno {

	@Id
	private String matricula;
	
	private String nome;

	public Aluno() {
		// TODO Auto-generated constructor stub
	}
	
	public Aluno(String matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}
	
	public Aluno(String matricula) {
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
