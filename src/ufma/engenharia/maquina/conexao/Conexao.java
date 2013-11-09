package ufma.engenharia.maquina.conexao;

import java.sql.Connection;


public class Conexao {
	
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	
	private static Connection conexao = null;

	public static String getDriver() {
		return driver;
	}

	public static void setDriver(String driver) {
		Conexao.driver = driver;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		Conexao.url = url;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		Conexao.user = user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Conexao.password = password;
	}

	public static Connection getConexao() {
		return conexao;
	}

	public static void setConexao(Connection conexao) {
		Conexao.conexao = conexao;
	}
	
	
	
	
}
