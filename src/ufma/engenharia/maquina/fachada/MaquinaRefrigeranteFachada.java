package ufma.engenharia.maquina.fachada;

import java.util.List;

import ufma.engenharia.maquina.dominio.Administrador;
import ufma.engenharia.maquina.dominio.Dinheiro;
import ufma.engenharia.maquina.dominio.Refrigerante;
import ufma.engenharia.maquina.dominio.Venda;

public interface MaquinaRefrigeranteFachada {
	
	/*-----------Dinheiro----------------*/
	List<Dinheiro> retornaDinheiros();
	/*------------------------------------*/
	
	/*-----------Estoque Dinheiro----------*/
	boolean atualizaEstoqueDinheiro(Dinheiro dinheiro, int quantidade);
	int retornaQuantidadeDinheiro(Dinheiro dinheiro);
	/*------------------------------------*/
	
	/*-----------Estoque Refrigerante----------*/
	boolean atualizaEstoqueRefrigerante(Refrigerante refrigerante, int quantidade, Double temperatura);
	int retornaQuantidadeRefrigerante(Refrigerante refrigerante);
	double retornaTemperaturaRefrigerante(Refrigerante refrigerante);
	/*------------------------------------*/
	
	/*-----------Refrigerante-------------*/
	List<Refrigerante> retornaRefrigerantes();
	/*------------------------------------*/
	
	/*-----------Venda-------------*/
	void salvarVenda(Refrigerante refrigerante, Double valor);
	List<Venda> recuperaVendas(Refrigerante refrigerante); 
	/*------------------------------------*/

	/*-----------Administrador-------------*/
	Administrador recuperaAdm(String login, String senha);
	/*------------------------------------*/


}
