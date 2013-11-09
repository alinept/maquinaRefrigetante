package ufma.engenharia.maquina.dao;

import ufma.engenharia.maquina.dominio.Dinheiro;

public interface EstoqueDinheiroDAO {
	
	public boolean atualiza(Dinheiro dinheiro, int quantidade);
	public int retornaQuantidade(Dinheiro dinheiro);
}
