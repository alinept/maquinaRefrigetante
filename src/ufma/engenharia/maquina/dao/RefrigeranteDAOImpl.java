package ufma.engenharia.maquina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ufma.engenharia.maquina.conexao.Conexao;
import ufma.engenharia.maquina.dominio.Refrigerante;

public class RefrigeranteDAOImpl implements RefrigeranteDAO{

public Connection con;
	
	public RefrigeranteDAOImpl() {
	 
		con = Conexao.open();
	}

	@Override
	public List<Refrigerante> findAll() {
		
		ResultSet rs = null;
		List<Refrigerante> refris = new ArrayList<Refrigerante>();
		
		String sql = "select * from refrigerante";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Refrigerante refri = new Refrigerante();
				refri.setCodigo(rs.getInt("codigo"));
				refri.setNome(rs.getString("nome"));
				refri.setPreco(rs.getDouble("preco"));
				
				refris.add(refri);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return refris;
	}

	@Override
	public Refrigerante findByCodigo(int codigo) {
		ResultSet rs = null;
		
		String sql = "select * from refrigerante where codigo = "+codigo;
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Refrigerante r = new Refrigerante();
				r.setCodigo(rs.getInt("codigo"));
				r.setNome(rs.getString("nome"));
				r.setPreco(rs.getDouble("preco"));
				
				return r;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return null;
	}


}
