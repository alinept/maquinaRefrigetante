package ufma.engenharia.maquina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ufma.engenharia.maquina.conexao.Conexao;
import ufma.engenharia.maquina.dominio.Dinheiro;
import ufma.engenharia.maquina.dominio.Refrigerante;
import ufma.engenharia.maquina.enums.TipoDinheiro;

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


}
