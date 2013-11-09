package ufma.engenharia.maquina.dominio;

import java.util.List;

public class Venda {

	private Integer codigo;
	private Refrigerante refrigerante;
	private List<Dinheiro> valorRecebido;
	private List<Dinheiro> troco;
	private Double valorTotal;
	
	public Refrigerante getRefrigerante() {
		return refrigerante;
	}
	public void setRefrigerante(Refrigerante refrigerante) {
		this.refrigerante = refrigerante;
	}
	public List<Dinheiro> getValorRecebido() {
		return valorRecebido;
	}
	public void setValorRecebido(List<Dinheiro> valorRecebido) {
		this.valorRecebido = valorRecebido;
	}
	public List<Dinheiro> getTroco() {
		return troco;
	}
	public void setTroco(List<Dinheiro> troco) {
		this.troco = troco;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
		
}
