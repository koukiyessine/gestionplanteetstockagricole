package tn.gestionplanteetstock.spring.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import tn.gestionplanteetstock.spring.Service.SessionService;

@Entity
public class Rapportplante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrapportplante;
    private String description;

    @OneToOne
    private Session session;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rapportplante")
    private List<Plante> listPlante = new ArrayList<>();

    public Long getIdrapportplante() {
        return idrapportplante;
    }

    public void setIdrapportplante(Long idrapportplante) {
        this.idrapportplante = idrapportplante;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Plante> getListPlante() {
        return listPlante;
    }

    public void setListPlante(List<Plante> listPlante) {
        this.listPlante = listPlante;
    }

    @Override
    public String toString() {
        return "Rapportplante [idrapportplante=" + idrapportplante + ", description=" + description + ", session="
                + session + ", listPlante=" + listPlante + "]";
    }

    public Rapportplante() {
        super();
    }

    public Rapportplante(Long idrapportplante, String description, Session session, List<Plante> listPlante) {
        super();
        this.idrapportplante = idrapportplante;
        this.description = description;
        this.session = session;
        this.listPlante = listPlante;
    }

	public void setNomplante(String nomplante) {
		// TODO Auto-generated method stub
		
	}

	public void setDateplante(LocalDate parse) {
		// TODO Auto-generated method stub
		
	}

	public List<Plante> getPlantes() {  
		// TODO Auto-generated method stub
		return null;
	}


	
 
    
    
}
