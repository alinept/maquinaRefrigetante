package ufma.engenharia.maquina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ufma.engenharia.maquina.conexao.Conexao;
import ufma.engenharia.maquina.dominio.Dinheiro;
import ufma.engenharia.maquina.enums.TipoDinheiro;

public class DinheiroDAOImpl implements DinheiroDAO{
	
	public Connection con;
	
	public DinheiroDAOImpl() {
	 
		con = Conexao.open();
	}

	@Override
	public List<Dinheiro> findAll() {
		
		ResultSet rs = null;
		List<Dinheiro> dinheiros = new ArrayList<Dinheiro>();
		
		String sql = "select * from dinheiro";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Dinheiro d = new Dinheiro();
				d.setCodigo(rs.getInt("codigo"));
				if(rs.getInt("tipo")==1) d.setTipo(TipoDinheiro.Moeda);
				else d.setTipo(TipoDinheiro.Cedula);
				d.setValor(rs.getDouble("valor"));
				
				dinheiros.add(d);
					
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return dinheiros;
	}

}
