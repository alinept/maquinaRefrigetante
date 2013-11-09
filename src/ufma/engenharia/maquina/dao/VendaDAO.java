package ufma.engenharia.maquina.dao;

import java.util.List;

import ufma.engenharia.maquina.dominio.Refrigerante;
import ufma.engenharia.maquina.dominio.Venda;

public interface VendaDAO {
	
	public void salvar(Refrigerante refrigerante, Double valor);
	public List<Venda> recuperaVendas(Refrigerante refrigerante); 
}
