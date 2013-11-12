package ufma.engenharia.maquina.fachada;

import java.util.List;

import ufma.engenharia.maquina.dominio.Administrador;
import ufma.engenharia.maquina.dominio.Dinheiro;
import ufma.engenharia.maquina.dominio.EstoqueDinheiro;
import ufma.engenharia.maquina.dominio.EstoqueRefrigerante;
import ufma.engenharia.maquina.dominio.Refrigerante;
import ufma.engenharia.maquina.dominio.Venda;

public interface MaquinaRefrigeranteFachada {
	
	/*-----------Dinheiro----------------*/
	List<Dinheiro> retornaDinheiros();
	Dinheiro findDinheiroByCodigo(int codigo);
	/*------------------------------------*/
	
	/*-----------Estoque Dinheiro----------*/
	boolean atualizaEstoqueDinheiro(Dinheiro dinheiro, int quantidade);
	int retornaQuantidadeDinheiro(Dinheiro dinheiro);
	List<EstoqueDinheiro> recuperaEstoqueDinheiro();
	/*------------------------------------*/
	
	/*-----------Estoque Refrigerante----------*/
	boolean atualizaEstoqueRefrigerante(Refrigerante refrigerante, int quantidade, Double temperatura);
	int retornaQuantidadeRefrigerante(Refrigerante refrigerante);
	double retornaTemperaturaRefrigerante(Refrigerante refrigerante);
	public List<EstoqueRefrigerante> recuperaEstoqueRefrigerante();
	/*------------------------------------*/
	
	/*-----------Refrigerante-------------*/
	List<Refrigerante> retornaRefrigerantes();
	/*------------------------------------*/
	
	/*-----------Venda-------------*/
	boolean salvarVenda(Refrigerante refrigerante, Double valor);
	List<Venda> recuperaVendas(Refrigerante refrigerante); 
	List<Venda> recuperaTodasVendas();
	boolean verificaPossibilidadeVenda(Refrigerante refrigerante);
	List<Dinheiro> calculaTroco(Refrigerante refrigerante, List<Dinheiro> dinheiroRecebido);
	double valorTotal(List<Dinheiro> dinheiro);
	/*------------------------------------*/

	/*-----------Administrador-------------*/
	Administrador recuperaAdm(String login, String senha);
	/*------------------------------------*/

	
}
