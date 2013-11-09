package ufma.engenharia.maquina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ufma.engenharia.maquina.conexao.Conexao;
import ufma.engenharia.maquina.dominio.Dinheiro;

public class EstoqueDinheiroDAOImpl implements EstoqueDinheiroDAO{

	public Connection con;
	
	public EstoqueDinheiroDAOImpl() {
	 
			con = Conexao.open();
	}
	
	@Override
	public boolean atualiza(Dinheiro dinheiro, int quantidade) {
		
		String sql = "update estoque_dinheiro set quantidade = ? where id_dinheiro ="+dinheiro.getCodigo();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, quantidade);
		
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int retornaQuantidade(Dinheiro dinheiro) {
		return 0;
	}
	
}
