package ufma.engenharia.maquina.fachada;

import java.util.ArrayList;
import java.util.Collections;
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
import ufma.engenharia.maquina.dominio.EstoqueDinheiro;
import ufma.engenharia.maquina.dominio.EstoqueDinheiroComparator;
import ufma.engenharia.maquina.dominio.EstoqueRefrigerante;
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
	public boolean salvarVenda(Refrigerante refrigerante, Double valor) {
		return vendaDAO.salvar(refrigerante, valor);
	}

	@Override
	public List<Venda> recuperaVendas(Refrigerante refrigerante) {
		return vendaDAO.recuperaVendas(refrigerante);
	}
	
	@Override
	public List<Venda> recuperaTodasVendas() {
		
		return vendaDAO.recuperarTodasVendas();
	}

	@Override
	public Administrador recuperaAdm(String login, String senha) {
		return adminDAO.recupera(login, senha);
	}

	@Override
	public Dinheiro findDinheiroByCodigo(int codigo) {
		return dinheiroDAO.findByCodigo(codigo);
	}

	@Override
	public List<EstoqueDinheiro> recuperaEstoqueDinheiro() {
		return estoqueDinheiroDAO.recuperaEstoque();
	}

	@Override
	public List<EstoqueRefrigerante> recuperaEstoqueRefrigerante() {
		return estoqueRefrigeranteDAO.recuperaEstoque();
	}

	@Override
	public boolean verificaPossibilidadeVenda(Refrigerante refrigerante) {
		
		if(estoqueRefrigeranteDAO.retornaQuantidade(refrigerante)>0) return true;

		return false;
	}

	@Override
	public List<Dinheiro> calculaTroco(Refrigerante refrigerante,
			List<Dinheiro> dinheiroRecebido) {
	
		List<EstoqueDinheiro> dinheiros = new ArrayList<EstoqueDinheiro>();
		List<Dinheiro> listaTroco = new ArrayList<Dinheiro>();
		
		dinheiros = estoqueDinheiroDAO.recuperaEstoque();
		double trocoCorrente = 0;
		
		double troco = valorTotal(dinheiroRecebido) - refrigerante.getPreco();
		
		EstoqueDinheiroComparator comparator = new EstoqueDinheiroComparator();
		Collections.sort(dinheiros, comparator);
		
		for(EstoqueDinheiro estoqueDinheiro: dinheiros)
		{
			if(estoqueDinheiro.getQuantidade() > 0)
			{
				trocoCorrente += estoqueDinheiro.getDinheiro().getValor();
				listaTroco.add(estoqueDinheiro.getDinheiro());
				
				if(trocoCorrente < troco)
				{
					while(trocoCorrente < troco && estoqueDinheiro.getQuantidade() > 0)
					{
						trocoCorrente += estoqueDinheiro.getDinheiro().getValor();
						listaTroco.add(estoqueDinheiro.getDinheiro());
					}
				}
				if(trocoCorrente == troco) break;
				
				if(trocoCorrente > troco ){
					trocoCorrente -= estoqueDinheiro.getDinheiro().getValor();
					listaTroco.remove(estoqueDinheiro.getDinheiro());
					 
				}
			}
		}
		if(valorTotal(listaTroco) == troco) return listaTroco;
		else return null;
	}

	@Override
	public double valorTotal(List<Dinheiro> dinheiro) {
		double valor = 0;
		
		for(Dinheiro d: dinheiro)
		{
			valor += d.getValor();
		}
		return valor;
	}
	
	

}
