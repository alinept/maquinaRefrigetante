package ufma.engenharia.maquina.dao;

import java.util.List;

import ufma.engenharia.maquina.dominio.Dinheiro;
import ufma.engenharia.maquina.dominio.EstoqueDinheiro;

public interface EstoqueDinheiroDAO {
	
	public boolean atualiza(Dinheiro dinheiro, int quantidade);
	public int retornaQuantidade(Dinheiro dinheiro);
	public List<EstoqueDinheiro> recuperaEstoque();
}
