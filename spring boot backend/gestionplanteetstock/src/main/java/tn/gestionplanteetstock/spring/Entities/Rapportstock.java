package tn.gestionplanteetstock.spring.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import tn.gestionplanteetstock.spring.Service.SessionService;

@Entity
public class Rapportstock {
	
	@OneToOne
	private Session session;
	
	
	@OneToMany(mappedBy = "rapportstock")
	private List<Produit> ListProduit;
	
	
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long idRapportstock;
private String descriptionStock;


public Session getSession() {
	return session;
}
public void setSession(Session session) {
	this.session = session;
}
public List<Produit> getListProduit() {
	return ListProduit;
}
public void setListProduit(List<Produit> listProduit) {
	ListProduit = listProduit;
}
public Long getIdRapportstock() {
	return idRapportstock;
}
public void setIdRapportstock(Long idRapportstock) {
	this.idRapportstock = idRapportstock;
}
public String getDescriptionStock() {
	return descriptionStock;
}
public void setDescriptionStock(String descriptionStock) {
	this.descriptionStock = descriptionStock;
}


@Override
public String toString() {
	return "Rapportstock [session=" + session + ", ListProduit=" + ListProduit + ", idRapportstock=" + idRapportstock
			+ ", descriptionStock=" + descriptionStock + "]";
}


public Rapportstock(Session session, List<Produit> listProduit, Long idRapportstock, String descriptionStock) {
	super();
	this.session = session;
	ListProduit = listProduit;
	this.idRapportstock = idRapportstock;
	this.descriptionStock = descriptionStock;
}

public Rapportstock() {
	super();
	// TODO Auto-generated constructor stub
}
public void add(Rapportstock rapportStock) {
	// TODO Auto-generated method stub
	
}



}
