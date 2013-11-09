package ufma.engenharia.maquina.dao;

import ufma.engenharia.maquina.dominio.Dinheiro;

public interface EstoqueDinheiroDAO {
	
	public void atualiza(Dinheiro dinheiro, int quantidade);
	public int retornaQuantidade(Dinheiro dinheiro);
}
