package academico.controlador;

import java.util.List;
import java.util.Vector;

public class AlunoDAO {
	
	private static List<Aluno> alunos = new Vector<>();

	
	static {
		alunos.add(new Aluno("111", "Gabriel"));
		alunos.add(new Aluno("222", "Marcos"));
		alunos.add(new Aluno("333", "Euripedes"));
		alunos.add(new Aluno("444", "Jehnifer"));
		alunos.add(new Aluno("555", "Joao"));

	}
	
	
	public void salva(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public List<Aluno> lista(){
		return alunos;
	}
}
