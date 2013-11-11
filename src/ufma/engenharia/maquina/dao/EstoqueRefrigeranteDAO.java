package ufma.engenharia.maquina.dao;

import java.util.List;

import ufma.engenharia.maquina.dominio.EstoqueRefrigerante;
import ufma.engenharia.maquina.dominio.Refrigerante;

public interface EstoqueRefrigeranteDAO {

	public boolean atualiza(Refrigerante refrigerante, int quantidade, Double temperatura);
	public int retornaQuantidade(Refrigerante refrigerante);
	public double retornaTemperatura(Refrigerante refrigerante);
	public List<EstoqueRefrigerante> recuperaEstoque();

}
