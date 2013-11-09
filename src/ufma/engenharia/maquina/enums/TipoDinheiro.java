package ufma.engenharia.maquina.enums;

public enum TipoDinheiro {


	Moeda(1,"Moeda"),
	Cedula(2,"Cédula");
	
	private int codigo;
	private String descricao;

	TipoDinheiro(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
