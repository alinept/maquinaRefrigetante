package ufma.engenharia.maquina.fachada;

import java.util.List;

import ufma.engenharia.maquina.dominio.Dinheiro;
import ufma.engenharia.maquina.dominio.Refrigerante;
import ufma.engenharia.maquina.dominio.Venda;

public class MaquinaRefrigeranteFachadaImpl implements MaquinaRefrigeranteFachada{

	@Override
	public List<Dinheiro> retornaDinheiros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean atualizaEstoqueDinheiro(Dinheiro dinheiro, int quantidade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int retornaQuantidadeDinheiro(Dinheiro dinheiro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean atualizaEstoqueRefrigerante(Refrigerante refrigerante,
			int quantidade, Double temperatura) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int retornaQuantidadeRefrigerante(Refrigerante refrigerante) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double retornaTemperaturaRefrigerante(Refrigerante refrigerante) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Refrigerante> retornaRefrigerantes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarVenda(Refrigerante refrigerante, Double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Venda> recuperaVendas(Refrigerante refrigerante) {
		// TODO Auto-generated method stub
		return null;
	}

}
