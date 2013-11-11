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


public class IndexAdminWindow extends Window{
    
	private static final long serialVersionUID = 1L;
	
	public Window win;
	public DataBinder binder;
	public InitialContext ctx;
	
	
	public IndexAdminWindow()
	{
		try {
			
			ctx = new InitialContext();
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void onCreate()
	{
		win = (Window) getFellow("win");
		binder = new AnnotateDataBinder(win);
		binder.loadAll();
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
	
	
}
