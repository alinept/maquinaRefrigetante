package ufma.engenharia.maquina.test.dao;

import junit.framework.Assert;

import org.junit.Test;

import ufma.engenharia.maquina.dao.EstoqueDinheiroDAO;
import ufma.engenharia.maquina.dao.EstoqueDinheiroDAOImpl;
import ufma.engenharia.maquina.dominio.Dinheiro;
import ufma.engenharia.maquina.enums.TipoDinheiro;

public class EstoqueDinheiroDAOTest {
	
	public EstoqueDinheiroDAO estoqueDinheiroDAO;
	
	@Test
	public void atualiza()
	{
		estoqueDinheiroDAO = new EstoqueDinheiroDAOImpl();
		Dinheiro dinheiro = new Dinheiro();
		dinheiro.setCodigo(1);
		dinheiro.setTipo(TipoDinheiro.Moeda);
		dinheiro.setValor(0.25);
		
		estoqueDinheiroDAO.atualiza(dinheiro, 9);
		
	}
	

}
