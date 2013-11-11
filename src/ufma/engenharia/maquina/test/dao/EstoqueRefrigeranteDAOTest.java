package ufma.engenharia.maquina.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import ufma.engenharia.maquina.dao.EstoqueDinheiroDAOImpl;
import ufma.engenharia.maquina.dao.EstoqueRefrigeranteDAO;
import ufma.engenharia.maquina.dao.EstoqueRefrigeranteDAOImpl;
import ufma.engenharia.maquina.dominio.EstoqueDinheiro;
import ufma.engenharia.maquina.dominio.EstoqueRefrigerante;
import ufma.engenharia.maquina.dominio.Refrigerante;

public class EstoqueRefrigeranteDAOTest {
public EstoqueRefrigeranteDAO estoqueRefrigeranteDAO;
	
	@Test
	@Ignore
	public void atualiza()
	{
		estoqueRefrigeranteDAO = new EstoqueRefrigeranteDAOImpl();
		Refrigerante r = new Refrigerante();
		r.setCodigo(1);
		r.setNome("Coca-Cola");
		
		assertEquals(true,estoqueRefrigeranteDAO.atualiza(r, 9, 3.0));
	}
	
	@Test
	@Ignore
	public void retornaQuantidade()
	{
		estoqueRefrigeranteDAO = new EstoqueRefrigeranteDAOImpl();
		Refrigerante refri = new Refrigerante();
		refri.setCodigo(1);
		
		assertEquals(10,estoqueRefrigeranteDAO.retornaQuantidade(refri));
	}
	
	@Test
	public void retornaTemperatura()
	{
		estoqueRefrigeranteDAO = new EstoqueRefrigeranteDAOImpl();
		Refrigerante refri = new Refrigerante();
		refri.setCodigo(1);
		refri.setNome("Coca-Cola");
		
		assertEquals(Double.valueOf(3), Double.valueOf(estoqueRefrigeranteDAO.retornaTemperatura(refri)));
		
	}
	
	@Test
	public void recuperaEstoque()
	{
		estoqueRefrigeranteDAO = new EstoqueRefrigeranteDAOImpl();
		
		List<EstoqueRefrigerante> estoques = new ArrayList<EstoqueRefrigerante>();
		
		estoques = estoqueRefrigeranteDAO.recuperaEstoque();
		
		assertNotNull(estoques);
	}

}
