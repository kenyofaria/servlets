package academico.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import academico.entidade.Aluno;

@WebServlet(urlPatterns="/alunos")
public class AlunoServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String matricula = req.getParameter("input-matricula");
		String nome = req.getParameter("input-nome");
		
		Aluno aluno = new Aluno(matricula, nome);
		AlunoDAO dao = new AlunoDAO();
		dao.salva(aluno);
		resp.sendRedirect("alunos.html");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AlunoDAO alunoDAO = new AlunoDAO();
		
		Gson gson = new Gson();
		
		String matricula = req.getParameter("matricula");
		if(matricula==null) {
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(gson.toJson(alunoDAO.lista()));
		}else {
			
			String operacao = req.getParameter("operacao");
			
			if(operacao != null && operacao.equals("excluir")) {
				alunoDAO.deleta(new Aluno(matricula));
				resp.sendRedirect("alunos.html");
			}else {
				
				if(req.getParameter("origem")!=null && req.getParameter("origem").equals("cadastro-aluno")) {
					String jsonAluno = gson.toJson(alunoDAO.get(matricula));
					resp.setContentType("application/json");
					resp.getWriter().print(jsonAluno.toString());
				}else {
					resp.sendRedirect("cadastro-aluno.html?matricula="+req.getParameter("matricula"));
				}
			}
		}
		
		
	}
}
