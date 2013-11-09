package ufma.engenharia.maquina.dominio;

import ufma.engenharia.maquina.enums.TipoDinheiro;

public class Dinheiro {
	
	private Integer codigo;
	private Double valor;
	private TipoDinheiro tipo;
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public TipoDinheiro getTipo() {
		return tipo;
	}
	public void setTipo(TipoDinheiro tipo) {
		this.tipo = tipo;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	

}
