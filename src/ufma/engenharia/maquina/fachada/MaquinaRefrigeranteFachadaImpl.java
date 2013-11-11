package ufma.engenharia.maquina.fachada;

import java.util.List;

import ufma.engenharia.maquina.dao.AdministradorDAO;
import ufma.engenharia.maquina.dao.AdministradorDAOImpl;
import ufma.engenharia.maquina.dao.DinheiroDAO;
import ufma.engenharia.maquina.dao.DinheiroDAOImpl;
import ufma.engenharia.maquina.dao.EstoqueDinheiroDAO;
import ufma.engenharia.maquina.dao.EstoqueDinheiroDAOImpl;
import ufma.engenharia.maquina.dao.EstoqueRefrigeranteDAO;
import ufma.engenharia.maquina.dao.EstoqueRefrigeranteDAOImpl;
import ufma.engenharia.maquina.dao.RefrigeranteDAO;
import ufma.engenharia.maquina.dao.RefrigeranteDAOImpl;
import ufma.engenharia.maquina.dao.VendaDAO;
import ufma.engenharia.maquina.dao.VendaDAOImpl;
import ufma.engenharia.maquina.dominio.Administrador;
import ufma.engenharia.maquina.dominio.Dinheiro;
import ufma.engenharia.maquina.dominio.Refrigerante;
import ufma.engenharia.maquina.dominio.Venda;

public class MaquinaRefrigeranteFachadaImpl implements MaquinaRefrigeranteFachada{

	private DinheiroDAO dinheiroDAO;
	private EstoqueDinheiroDAO estoqueDinheiroDAO;
	private EstoqueRefrigeranteDAO estoqueRefrigeranteDAO;
	private RefrigeranteDAO refrigeranteDAO;
	private VendaDAO vendaDAO;
	private AdministradorDAO adminDAO;
	
	public MaquinaRefrigeranteFachadaImpl()
	{
		dinheiroDAO = new DinheiroDAOImpl();
		estoqueDinheiroDAO = new EstoqueDinheiroDAOImpl();
		estoqueRefrigeranteDAO = new EstoqueRefrigeranteDAOImpl();
		refrigeranteDAO = new RefrigeranteDAOImpl();
		vendaDAO = new VendaDAOImpl();
		adminDAO = new AdministradorDAOImpl();
	}
	
	@Override
	public List<Dinheiro> retornaDinheiros() {
		
		return dinheiroDAO.findAll();
	}

	@Override
	public boolean atualizaEstoqueDinheiro(Dinheiro dinheiro, int quantidade) {
		
		return estoqueDinheiroDAO.atualiza(dinheiro, quantidade);
	}

	@Override
	public int retornaQuantidadeDinheiro(Dinheiro dinheiro) {
		
		return estoqueDinheiroDAO.retornaQuantidade(dinheiro);
	}

	@Override
	public boolean atualizaEstoqueRefrigerante(Refrigerante refrigerante,
			int quantidade, Double temperatura) {
		
		return estoqueRefrigeranteDAO.atualiza(refrigerante, quantidade, temperatura);
	
	}

	@Override
	public int retornaQuantidadeRefrigerante(Refrigerante refrigerante) {
		
		return estoqueRefrigeranteDAO.retornaQuantidade(refrigerante);
	}

	@Override
	public double retornaTemperaturaRefrigerante(Refrigerante refrigerante) {
		
		return estoqueRefrigeranteDAO.retornaTemperatura(refrigerante);
	}

	@Override
	public List<Refrigerante> retornaRefrigerantes() {
		
		return refrigeranteDAO.findAll();
	}

	@Override
	public void salvarVenda(Refrigerante refrigerante, Double valor) {
		
		
	}

	@Override
	public List<Venda> recuperaVendas(Refrigerante refrigerante) {
		
		return null;
	}

	@Override
	public Administrador recuperaAdm(String login, String senha) {
		return adminDAO.recupera(login, senha);
	}

}
