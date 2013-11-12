package ufma.engenharia.maquina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ufma.engenharia.maquina.conexao.Conexao;
import ufma.engenharia.maquina.dominio.EstoqueDinheiro;
import ufma.engenharia.maquina.dominio.Refrigerante;
import ufma.engenharia.maquina.dominio.Venda;

public class VendaDAOImpl implements VendaDAO{
	
	public Connection con;
	public VendaDAO vendaDAO;
	public RefrigeranteDAO refriDAO;
	
	public VendaDAOImpl()
	{
		con = Conexao.open();
		vendaDAO = new VendaDAOImpl();
		refriDAO = new RefrigeranteDAOImpl();
	}
	
	@Override
	public boolean salvar(Refrigerante refrigerante, Double valor) {
		
		String sql = "insert into venda(id_refrigerante, valor) values ( ? , ? )";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, refrigerante.getCodigo());
			ps.setDouble(2, valor);
		
			ps.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Venda> recuperaVendas(Refrigerante refrigerante) {
		
		List<Venda> vendas = new ArrayList<Venda>();
		ResultSet rs = null;

		String sql = "select * from venda where id_refrigerante = " + refrigerante.getCodigo();
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Venda venda = new Venda();
				venda.setCodigo(rs.getInt("codigo"));
				venda.setRefrigerante(refriDAO.findByCodigo(rs.getInt("id_refrigerante")));
				venda.setValorTotal(rs.getDouble("valor"));
				
				vendas.add(venda);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return vendas;
		
	}

	@Override
	public List<Venda> recuperarTodasVendas() {
		

		List<Venda> vendas = new ArrayList<Venda>();
		ResultSet rs = null;

		String sql = "select * from venda ";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Venda venda = new Venda();
				venda.setCodigo(rs.getInt("codigo"));
				venda.setRefrigerante(refriDAO.findByCodigo(rs.getInt("id_refrigerante")));
				venda.setValorTotal(rs.getDouble("valor"));
				
				vendas.add(venda);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return vendas;
		
	}
	


}
