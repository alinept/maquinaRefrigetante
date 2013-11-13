package ufma.engenharia.maquina.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ufma.engenharia.maquina.dao.VendaDAO;
import ufma.engenharia.maquina.dominio.Refrigerante;
import ufma.engenharia.maquina.dominio.Venda;

public class VendaDAOTest {
	
	public VendaDAO vendaDAO;
	
	@Test
	public void retornaVendaRefri()
	{
		List<Venda> vendasRefri = new ArrayList<Venda>();
		Refrigerante r = new Refrigerante();
		r.setCodigo(1);
		
		vendasRefri = vendaDAO.recuperaVendas(r);
		
		assertNotNull(vendasRefri);
	}
	
	@Test
	public void retornaTodasVendas()
	{
		List<Venda> vendas = new ArrayList<Venda>();
		Refrigerante r = new Refrigerante();
		r.setCodigo(1);
		
		vendas = vendaDAO.recuperarTodasVendas();
		
		assertNotNull(vendas);
		
	}
	
}
