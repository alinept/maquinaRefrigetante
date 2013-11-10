package ufma.engenharia.maquina.test.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ufma.engenharia.maquina.dao.EstoqueRefrigeranteDAO;
import ufma.engenharia.maquina.dao.EstoqueRefrigeranteDAOImpl;
import ufma.engenharia.maquina.dominio.Refrigerante;

public class EstoqueRefrigeranteDAOTest {
public EstoqueRefrigeranteDAO estoqueRefrigeranteDAO;
	
	@Test
	public void atualiza()
	{
		estoqueRefrigeranteDAO = new EstoqueRefrigeranteDAOImpl();
		Refrigerante r = new Refrigerante();
		r.setCodigo(1);
		r.setNome("Coca-Cola");
		
		assertEquals(true,estoqueRefrigeranteDAO.atualiza(r, 9, 3.0));
	}
	

}
