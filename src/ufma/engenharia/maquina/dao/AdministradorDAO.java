package ufma.engenharia.maquina.dao;

import ufma.engenharia.maquina.dominio.Administrador;

public interface AdministradorDAO {

	Administrador recupera(String login, String senha);
}
