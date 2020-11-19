package poo2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import poo2.dao.BancoDeDados;
import poo2.entidade.Empresa;

//DAO - Data Access Object
public class EmpresaDAO {

	private Connection conexao;

	public void salva(Empresa empresa) {
		conexao = BancoDeDados.getConexao();
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("insert into empresas (cnpj, nome) values (?, ?)");
			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getNome());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleta(String cnpj) {
		conexao = BancoDeDados.getConexao();
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("delete empresas where cnpj = ?");
			ps.setString(1, cnpj);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
