package ufma.engenharia.maquina.window;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Window;

import ufma.engenharia.maquina.dominio.Refrigerante;
import ufma.engenharia.maquina.fachada.MaquinaRefrigeranteFachada;
import ufma.engenharia.maquina.fachada.MaquinaRefrigeranteFachadaImpl;


public class IndexWindow extends Window{
    
	private static final long serialVersionUID = 1L;
	
	public Window win;
	public DataBinder binder;
	public InitialContext ctx;
	
	public Refrigerante refrigerante;
	public List<Refrigerante> refris;
	public MaquinaRefrigeranteFachada maquinaFachada;
	
	
	public IndexWindow()
	{
		try {
			
			ctx = new InitialContext();
			refrigerante = new Refrigerante();
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
		binder.loadAll();
	}
		
}
