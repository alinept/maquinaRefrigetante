package ufma.engenharia.maquina.dao;

import java.util.List;

import ufma.engenharia.maquina.dominio.Dinheiro;

public interface DinheiroDAO {
	
	List<Dinheiro> findAll();

}
