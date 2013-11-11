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
import ufma.engenharia.maquina.dominio.EstoqueDinheiro;
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
		
//		Carregar uma colecao de objetos estoque de moedas na ordem: 0,25; 0,5; 1; 2; 5; 10
//		Carregar uma colecao de objetos estoque de refrigerantes
//
//		método recebe valor do troco a ser dado ao clinte: troco
//		   
//		   
//		   for(Estoque estoque: ColecaoEstoque){
//				if(estoque.quantidade){
//				  trocoCorrente+= estoque.valor;
//				  if(trocoCorrente<troco){
//					while( trocoCorrente<troco){
//					 trocoCorrente+=estoque.valor;
//					}  
//				  }
//				  else if(trocoCorrente==troco) break;
//				  
//				  else{
//					trocoCorrente-=estoque.valor;
//				  }
//				}
//		   
//		}
		
		double troco = valorTotal(dinheiroRecebido) - refrigerante.getPreco();
		
		return null;
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
