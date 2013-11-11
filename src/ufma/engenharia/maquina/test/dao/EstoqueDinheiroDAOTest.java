package ufma.engenharia.maquina.test.dao;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import ufma.engenharia.maquina.dao.EstoqueDinheiroDAO;
import ufma.engenharia.maquina.dao.EstoqueDinheiroDAOImpl;
import ufma.engenharia.maquina.dominio.Dinheiro;
import ufma.engenharia.maquina.dominio.EstoqueDinheiro;
import ufma.engenharia.maquina.enums.TipoDinheiro;

public class EstoqueDinheiroDAOTest {
	
	public EstoqueDinheiroDAO estoqueDinheiroDAO;
	
	@Test
	@Ignore
	public void atualiza()
	{
		estoqueDinheiroDAO = new EstoqueDinheiroDAOImpl();
		Dinheiro dinheiro = new Dinheiro();
		dinheiro.setCodigo(1);
		dinheiro.setTipo(TipoDinheiro.Moeda);
		dinheiro.setValor(0.25);
				
		assertEquals(true,estoqueDinheiroDAO.atualiza(dinheiro, 9));
	}
	
	@Test
	public void retornaQuantidade()
	{
		estoqueDinheiroDAO = new EstoqueDinheiroDAOImpl();
		Dinheiro dinheiro = new Dinheiro();
		dinheiro.setCodigo(1);
		
		assertEquals(9,estoqueDinheiroDAO.retornaQuantidade(dinheiro));
	}
	
	@Test
	public void retornaEstoque()
	{
		estoqueDinheiroDAO = new EstoqueDinheiroDAOImpl();
		
		List<EstoqueDinheiro> estoques = new ArrayList<EstoqueDinheiro>();
		
		estoques = estoqueDinheiroDAO.recuperaEstoque();
		
		assertNotNull(estoques);
		
	}
	
	

}
