package academico.controlador;

public class Aluno {

	private String matricula;
	private String nome;

	public Aluno(String matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

}
