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

import ufma.engenharia.maquina.dao.AdministradorDAO;
import ufma.engenharia.maquina.dominio.Administrador;
import ufma.engenharia.maquina.fachada.MaquinaRefrigeranteFachada;
import ufma.engenharia.maquina.fachada.MaquinaRefrigeranteFachadaImpl;

public class LoginWindow extends Window{
    
	private static final long serialVersionUID = 1L;
	
	public Window win;
	public DataBinder binder;
	public InitialContext ctx;
	
	public Administrador admin;
	public MaquinaRefrigeranteFachada maquinaFachada;
	public String login;
	public String senha;
	
	public LoginWindow()
	{
		try {
			
			ctx = new InitialContext();
			admin = new Administrador();
			maquinaFachada = new MaquinaRefrigeranteFachadaImpl();
			
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
	
	public void login()
	{
		if(!login.equals("") && !senha.equals(""))
		{
			admin = maquinaFachada.recuperaAdm(login, senha);
			
			if(admin != null)
			{
			//	Executions.sendRedirect("/manutencao/index.zul");
				Messagebox.show("Login efetuado com sucesso");
			}else{
				Messagebox.show("login ou senha incorretos");
				login = "";
				senha = "";
				binder.loadAll();
			}
		}else{
			Messagebox.show("Preencha todos os campos");
			
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
