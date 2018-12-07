package jsf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import jsf.model.Contato;

@ManagedBean(name = "contatoBean")
@ViewScoped
public class ContatoBean {
	List<Contato> listaContatos;
	Contato c;
		
	public ContatoBean() {
		this.c = new Contato();
		this.listaContatos = new ArrayList<Contato>();
	}
	
	public void adicionarContato(){
		if(!listaContatos.contains(c)){			
			c.setId(listaContatos.size()+1);
			listaContatos.add(c);
			System.out.println("lista "+ listaContatos);	
			
			FacesContext context = FacesContext.getCurrentInstance();	
			FacesMessage mensagem = new FacesMessage("Cadastro de contato realizado com sucesso!");
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			context.addMessage(null, mensagem);
		} else {	
			FacesContext context = FacesContext.getCurrentInstance();	
			FacesMessage mensagem = new FacesMessage("Atualização de contato realizado com sucesso!");
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			context.addMessage(null, mensagem);
		}	
		
		this.c = new Contato();
	}
	
	public void editarContato(Contato c){
		this.c = c;
	}
	
	public void removerContato(Contato c){		
		listaContatos.remove(c);
				
		FacesContext context = FacesContext.getCurrentInstance();	
		FacesMessage mensagem = new FacesMessage("Contato removido com sucesso!");
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		context.addMessage(null, mensagem);	
		
		return;		
	}
	
	public List<Contato> getListaContatos() {
		return listaContatos;
	}

	public void setListaContatos(List<Contato> listaContatos) {
		this.listaContatos = listaContatos;
	}

	public Contato getC() {
		return c;
	}

	public void setC(Contato c) {
		this.c = c;
	}
		
}
