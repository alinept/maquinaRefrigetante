package ufma.engenharia.maquina.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ufma.engenharia.maquina.dao.RefrigeranteDAO;
import ufma.engenharia.maquina.dao.RefrigeranteDAOImpl;
import ufma.engenharia.maquina.dominio.Refrigerante;

public class RefrigeranteDAOTest {
	
	public RefrigeranteDAO refrigeranteDAO;
	
	@Test
	public void retornaTodos()
	{
		refrigeranteDAO = new RefrigeranteDAOImpl();
		List<Refrigerante> refris = new ArrayList<Refrigerante>();
		
		refris = refrigeranteDAO.findAll();
		
		assertEquals(4, refris.size());
	}

	@Test
	public void findByCodigo()
	{
		refrigeranteDAO = new RefrigeranteDAOImpl();
		Refrigerante r = new Refrigerante();
		
		r = refrigeranteDAO.findByCodigo(1);
		
		assertNotNull(r);
	}
}
