package ufma.engenharia.maquina.window;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Window;

import ufma.engenharia.maquina.dominio.EstoqueDinheiro;
import ufma.engenharia.maquina.fachada.MaquinaRefrigeranteFachada;
import ufma.engenharia.maquina.fachada.MaquinaRefrigeranteFachadaImpl;

public class EstoqueDinheiroWindow extends Window{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Window win;
	public DataBinder binder;
	public InitialContext ctx;
	public MaquinaRefrigeranteFachada maquinaFachada;
	public List<EstoqueDinheiro> estoques;
	public EstoqueDinheiro estoque;
	
	public EstoqueDinheiroWindow()
	{
		try {
			
			ctx = new InitialContext();
			maquinaFachada = new MaquinaRefrigeranteFachadaImpl();
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void onCreate()
	{
		win = (Window) getFellow("win");
		binder = new AnnotateDataBinder(win);
		estoques = maquinaFachada.recuperaEstoqueDinheiro();
		binder.loadAll();
	}
	
	public void atualizar()
	{
		if(estoque != null)
		{
			if(maquinaFachada.atualizaEstoqueDinheiro(estoque.getDinheiro(), estoque.getQuantidade()))
			{
				Messagebox.show("Estoque atualizado com sucesso");
			}else{
				Messagebox.show("Erro ao atualizar estoque");
			}
			binder.loadAll();
		}
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
	
	public void irRelatorio()
	{
		Executions.sendRedirect("/manutencao/estoqueRefrigerante.zul");
		binder.loadAll();
	}
	
	public List<EstoqueDinheiro> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<EstoqueDinheiro> estoques) {
		this.estoques = estoques;
	}
	
	

}
