package ufma.engenharia.maquina.window;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Window;

import ufma.engenharia.maquina.dominio.EstoqueRefrigerante;
import ufma.engenharia.maquina.fachada.MaquinaRefrigeranteFachada;
import ufma.engenharia.maquina.fachada.MaquinaRefrigeranteFachadaImpl;

public class EstoqueRefrigeranteWindow extends Window{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Window win;
	public DataBinder binder;
	public InitialContext ctx;
	public MaquinaRefrigeranteFachada maquinaFachada;
	public List<EstoqueRefrigerante> estoques;
	public EstoqueRefrigerante estoque;
	
	public EstoqueRefrigeranteWindow()
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
		estoques = maquinaFachada.recuperaEstoqueRefrigerante();
		binder.loadAll();
	}

	public void atualizar()
	{
		if(estoque != null)
		{
			if(estoque != null)
			{
				if(maquinaFachada.atualizaEstoqueRefrigerante(estoque.getRefrigerante(), estoque.getQuantidade(), estoque.getTemperatura()))
				{
					Messagebox.show("Estoque atualizado com sucesso");
				}else{
					Messagebox.show("Erro ao atualizar estoque");
				}
				binder.loadAll();
			}
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

	public List<EstoqueRefrigerante> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<EstoqueRefrigerante> estoques) {
		this.estoques = estoques;
	}
	
	
}
