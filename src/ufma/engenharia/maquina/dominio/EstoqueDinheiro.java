package ufma.engenharia.maquina.dominio;

public class EstoqueDinheiro implements Comparable<EstoqueDinheiro>{
	
	private Dinheiro dinheiro;
	private Integer quantidade;
	
	public Dinheiro getDinheiro() {
		return dinheiro;
	}
	public void setDinheiro(Dinheiro dinheiro) {
		this.dinheiro = dinheiro;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public int compareTo(EstoqueDinheiro estoqueConta) {
		if(this.dinheiro.getValor() > estoqueConta.dinheiro.getValor())
		{
			return -1;
		}
		if(this.dinheiro.getValor() < estoqueConta.dinheiro.getValor())
		{
			return 1;
		}
		return 0;
	}


}
