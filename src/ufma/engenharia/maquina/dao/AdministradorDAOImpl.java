package ufma.engenharia.maquina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ufma.engenharia.maquina.conexao.Conexao;
import ufma.engenharia.maquina.dominio.Administrador;

public class AdministradorDAOImpl implements AdministradorDAO{

	public Connection con;
	
	public AdministradorDAOImpl() {
		 
		con = Conexao.open();
	}
	@Override
	public Administrador recupera(String login, String senha) {

		ResultSet rs = null;
		Administrador adm = new Administrador();
		
		String sql = "select * from administrador where login = ? and senha = ?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, login);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				adm.setLogin(rs.getString("login"));
				adm.setSenha(rs.getString("senha"));
				
				return adm;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return null;
	}

	
}
