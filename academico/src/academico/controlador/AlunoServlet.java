package academico.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

@WebServlet(urlPatterns="/alunos")
public class AlunoServlet extends HttpServlet{


	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String matricula = req.getParameter("input-matricula");
		String nome = req.getParameter("input-nome");
		
		
		Aluno aluno = new Aluno(matricula, nome);
		AlunoDAO dao = new AlunoDAO();
		dao.salva(aluno);
		
//		List<Aluno> listaDeAlunos = dao.lista();
//		
//		for (Aluno a : listaDeAlunos) {
//			System.out.println("matricula: " + a.getMatricula());
//			System.out.println("nome: " + a.getNome());
//			
//		}
		resp.sendRedirect("alunos.html");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AlunoDAO alunoDAO = new AlunoDAO();
		
		Gson gson = new Gson();
	
		JsonElement json = gson.toJsonTree(alunoDAO.lista());
		
		resp.setContentType("application/json");
		resp.getWriter().print(json.toString());
		
		
	}
}
