package ufma.engenharia.maquina.test.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import ufma.engenharia.maquina.dao.AdministradorDAO;
import ufma.engenharia.maquina.dao.AdministradorDAOImpl;
import ufma.engenharia.maquina.dominio.Administrador;

public class AdministradorDAOTest {
	
public AdministradorDAO administradorDAO;
	
	
	@Test
	public void verificaLogin()
	{
		administradorDAO = new AdministradorDAOImpl();
		Administrador adm = new Administrador();
		adm = administradorDAO.recupera("admin","admin");
		
		assertNotNull(adm);
	}


}
