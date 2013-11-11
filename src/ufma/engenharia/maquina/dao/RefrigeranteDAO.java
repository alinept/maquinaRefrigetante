package ufma.engenharia.maquina.dao;

import java.util.List;

import ufma.engenharia.maquina.dominio.Refrigerante;

public interface RefrigeranteDAO{
	
	List<Refrigerante> findAll();
	Refrigerante findByCodigo(int codigo);
	
}
