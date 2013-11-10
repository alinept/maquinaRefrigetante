package ufma.engenharia.maquina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ufma.engenharia.maquina.conexao.Conexao;
import ufma.engenharia.maquina.dominio.Refrigerante;

public class EstoqueRefrigeranteDAOImpl implements EstoqueRefrigeranteDAO{

	public Connection con;

	public EstoqueRefrigeranteDAOImpl()
	{
		con = Conexao.open();
	}
	
	@Override
	public boolean atualiza(Refrigerante refrigerante, int quantidade,
			Double temperatura) {

		String sql = "update estoque_refrigerante set quantidade = ?, temperatura = ?  where id_refrigerante = " + refrigerante.getCodigo();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, quantidade);
			ps.setDouble(2, temperatura);
		
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public int retornaQuantidade(Refrigerante refrigerante) {
		ResultSet rs = null;
		int quantidade = 0;
		
		String sql = "select * from estoque_refrigerante where id_refrigerante ="+ refrigerante.getCodigo();
		
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
	public double retornaTemperatura(Refrigerante refrigerante) {
		
		ResultSet rs = null;
		double temperatura = 0;
		
		String sql = "select * from estoque_refrigerante where id_refrigerante ="+ refrigerante.getCodigo();
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				temperatura = rs.getDouble("temperatura");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return temperatura;
	}

}
