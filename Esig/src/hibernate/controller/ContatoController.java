package hibernate.controller;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import hibernate.dao.ContatoDaoImpl;
import hibernate.model.Contato;

@ManagedBean
@ViewScoped
public class ContatoController {

    private Contato contato;  
    private ContatoDaoImpl dao;
    private List<Contato> lista;

      
    public ContatoController() {    	
    	this.contato = new Contato();
    	this.dao = new ContatoDaoImpl();
    	this.lista = new ArrayList<Contato>();
        this.lista = dao.list();      
              
    }        
    
	public void salvar() { 		
		FacesContext fc = FacesContext.getCurrentInstance();		

		if (contato.getId() == 0) {
			FacesMessage messagem = new FacesMessage("Contato cadastrado com sucesso!");
			messagem.setSeverity(FacesMessage.SEVERITY_INFO);
			fc.addMessage(null, messagem);						
			dao.save(contato);			
	    	this.contato = new Contato();			    	
	    	this.lista = dao.list();	
		} else {		
	    	FacesMessage messagem = new FacesMessage("Cliente atualizado com sucesso!");
			messagem.setSeverity(FacesMessage.SEVERITY_INFO);
			fc.addMessage(null, messagem);	
			dao.update(contato);
			this.contato = new Contato();
			this.lista = dao.list();
		}	    			
    }
    
    public void remover(Contato contato){   
    	FacesContext fc = FacesContext.getCurrentInstance();		
		FacesMessage messagem = new FacesMessage("Cliente removido com sucesso!");
		messagem.setSeverity(FacesMessage.SEVERITY_INFO);
		fc.addMessage(null, messagem);	
		contato.setAtivo(false);		
		dao.update(contato);
    	this.contato = new Contato();
    	this.lista = dao.list();
	}   
    
    public void editar(Contato contato){
    	this.contato = contato;  
    }
     

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public ContatoDaoImpl getDao() {
		return dao;
	}

	public void setDao(ContatoDaoImpl dao) {
		this.dao = dao;
	}

	public List<Contato> getLista() {
		return lista;
	}

	public void setLista(List<Contato> lista) {
		this.lista = lista;
	} 

}
