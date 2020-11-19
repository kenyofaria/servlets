package poo2;

import poo2.dao.EmpresaDAO;
import poo2.entidade.Empresa;

public class Main {

	public static void main(String[] args) {
		EmpresaDAO dao = new EmpresaDAO();
		dao.salva(new Empresa("03.876.987/0001-89","IFG"));
		dao.salva(new Empresa("03.875.987/0001-89","USP"));
		dao.salva(new Empresa("03.879.987/0001-89","UFSCAR"));
		dao.salva(new Empresa("03.878.987/0001-89","UNICAMP"));
		dao.salva(new Empresa("03.832.987/0001-89","ITA"));
		dao.salva(new Empresa("03.800.987/0001-89","UFPE"));
		System.out.println("pronto!");
	}
	
}
