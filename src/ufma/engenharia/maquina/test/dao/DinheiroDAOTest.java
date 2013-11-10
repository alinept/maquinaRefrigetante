package ufma.engenharia.maquina.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ufma.engenharia.maquina.dao.DinheiroDAO;
import ufma.engenharia.maquina.dao.DinheiroDAOImpl;
import ufma.engenharia.maquina.dominio.Dinheiro;

public class DinheiroDAOTest {
	
public DinheiroDAO dinheiroDAO;
	
	
	@Test
	public void retornaTodos()
	{
		dinheiroDAO = new DinheiroDAOImpl();
		List<Dinheiro> dinheiros = new ArrayList<Dinheiro>();
		
		dinheiros = dinheiroDAO.findAll();
		
		assertEquals(6, dinheiros.size());
	}

}
