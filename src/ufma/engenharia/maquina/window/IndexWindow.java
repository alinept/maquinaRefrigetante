package ufma.engenharia.maquina.window;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Window;

import ufma.engenharia.maquina.dominio.Dinheiro;
import ufma.engenharia.maquina.dominio.Refrigerante;
import ufma.engenharia.maquina.dominio.Venda;
import ufma.engenharia.maquina.fachada.MaquinaRefrigeranteFachada;
import ufma.engenharia.maquina.fachada.MaquinaRefrigeranteFachadaImpl;


public class IndexWindow extends Window{
    
	private static final long serialVersionUID = 1L;
	
	public Window win;
	public DataBinder binder;
	public InitialContext ctx;
	
	public Refrigerante refrigerante;
	public Dinheiro dinheiro;
	public List<Refrigerante> refris;
	public List<Dinheiro> listaDinheiro;
	
	public List<Dinheiro> dinheiroRecebido;
	public int quantidadeDinheiro;
	public Venda venda;
	
	public MaquinaRefrigeranteFachada maquinaFachada;
	
	
	public IndexWindow()
	{
		try {
			
			ctx = new InitialContext();
			refrigerante = new Refrigerante();
			dinheiro = new Dinheiro();
			
			maquinaFachada = new MaquinaRefrigeranteFachadaImpl();
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void onCreate()
	{
		win = (Window) getFellow("win");
		binder = new AnnotateDataBinder(win);
		
		refris = new ArrayList<Refrigerante>();
		refris = maquinaFachada.retornaRefrigerantes();
		
		listaDinheiro = new ArrayList<Dinheiro>();
		listaDinheiro = maquinaFachada.retornaDinheiros();
		
		dinheiroRecebido = new ArrayList<Dinheiro>();
		
		refrigerante = new Refrigerante();
		binder.loadAll();
	}
	
	public void adicionarValorRecebido()
	{
		
		if(dinheiro !=null && quantidadeDinheiro!=0 )
		{
			for(int i=0; i<quantidadeDinheiro;i++)
			{
				dinheiroRecebido.add(dinheiro);
			}
			dinheiro = new Dinheiro();
			quantidadeDinheiro = 0;
			
			binder.loadAll();
		}else{
			Messagebox.show("Preencha todos os campos do valor a pagar");
		}
	}
	
	public void efetuarCompra()
	{
		List<Dinheiro> troco = new ArrayList<Dinheiro>();
		
		if(refrigerante != null && dinheiroRecebido.size() > 0)
		{
			if(maquinaFachada.verificaPossibilidadeVenda(refrigerante))
			{
				if(refrigerante.getPreco() <= maquinaFachada.valorTotal(dinheiroRecebido))
				{
					troco = maquinaFachada.calculaTroco(refrigerante, dinheiroRecebido);
			
					if(troco != null)
					{
						
					}else{
						Messagebox.show("Desculpe, n�o temos troco. Seu valor de R$"+maquinaFachada.valorTotal(dinheiroRecebido)+" ser� devolvido");
					}
				}else{
					Messagebox.show("Insira mais moedas, valor insuficiente");
				}
			}else{
				Messagebox.show("Desculpe, mas estamos sem este refrigerante no estoque");
			}
		}else{
			Messagebox.show("Preencha todos os campos");
		}
	}

	public void cancelarCompra()
	{
		
	}
	
	public void irAtualizarEstoqueDinheiro()
	{
		Executions.sendRedirect("/manutencao/estoqueDinheiro.zul");
		binder.loadAll();
	}
	
	public void irAtualizarEstoqueRefrigerante()
	{
		Executions.sendRedirect("/manutencao/estoqueRefrigerante.zul");
		binder.loadAll();
	}
	
	public Refrigerante getRefrigerante() {
		return refrigerante;
	}

	public void setRefrigerante(Refrigerante refrigerante) {
		this.refrigerante = refrigerante;
	}

	public List<Refrigerante> getRefris() {
		return refris;
	}

	public void setRefris(List<Refrigerante> refris) {
		this.refris = refris;
	}

	public Dinheiro getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(Dinheiro dinheiro) {
		this.dinheiro = dinheiro;
	}

	public List<Dinheiro> getListaDinheiro() {
		return listaDinheiro;
	}

	public void setListaDinheiro(List<Dinheiro> listaDinheiro) {
		this.listaDinheiro = listaDinheiro;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Dinheiro> getDinheiroRecebido() {
		return dinheiroRecebido;
	}

	public void setDinheiroRecebido(List<Dinheiro> dinheiroRecebido) {
		this.dinheiroRecebido = dinheiroRecebido;
	}

	public int getQuantidadeDinheiro() {
		return quantidadeDinheiro;
	}

	public void setQuantidadeDinheiro(int quantidadeDinheiro) {
		this.quantidadeDinheiro = quantidadeDinheiro;
	}
	
	
		
}
