package ufma.engenharia.maquina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ufma.engenharia.maquina.conexao.Conexao;
import ufma.engenharia.maquina.dominio.Dinheiro;
import ufma.engenharia.maquina.dominio.EstoqueDinheiro;

public class EstoqueDinheiroDAOImpl implements EstoqueDinheiroDAO{

	public Connection con;
	public DinheiroDAO dinheiroDAO;
	
	public EstoqueDinheiroDAOImpl() {
	 
			con = Conexao.open();
			dinheiroDAO = new DinheiroDAOImpl();
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
		
		ResultSet rs = null;
		int quantidade = 0;
		
		String sql = "select * from estoque_dinheiro where id_dinheiro ="+dinheiro.getCodigo();
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				quantidade = rs.getInt("quantidade");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return quantidade;
	}

	@Override
	public List<EstoqueDinheiro> recuperaEstoque() {

		ResultSet rs = null;
		List<EstoqueDinheiro> estoque = new ArrayList<EstoqueDinheiro>();
		
		String sql = "select * from estoque_dinheiro";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				EstoqueDinheiro d = new EstoqueDinheiro();
				d.setQuantidade(rs.getInt("quantidade"));
				d.setDinheiro(dinheiroDAO.findByCodigo(rs.getInt("id_dinheiro")));
				
				estoque.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return estoque;
	}
	
	
}
