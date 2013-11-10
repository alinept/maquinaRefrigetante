package ufma.engenharia.maquina.dao;

import ufma.engenharia.maquina.dominio.Refrigerante;

public interface EstoqueRefrigeranteDAO {

	public boolean atualiza(Refrigerante refrigerante, int quantidade, Double temperatura);
	public int retornaQuantidade(Refrigerante refrigerante);

}
