package tn.gestionplanteetstock.spring.Entities;


import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

@Entity
public class Plante{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Idplante;
    private String nomplante;
    private String typedesol;
    private Date dateplante;
    private Date datereclote;
    private String etatdesante;
    private String vitamine;
    private String nomChamp;
    private Float ph;
    
    @OneToOne
    @JoinColumn(name = "session_id")
    private Session session;
   
    
    
   @ManyToOne
   private Rapportplante rapportplante;



public Long getIdplante() {
	return Idplante;
}



public void setIdplante(Long idplante) {
	Idplante = idplante;
}



public String getNomplante() {
	return nomplante;
}



public void setNomplante(String nomplante) {
	this.nomplante = nomplante;
}



public String getTypedesol() {
	return typedesol;
}



public void setTypedesol(String typedesol) {
	this.typedesol = typedesol;
}



public Date getDateplante() {
	return dateplante;
}



public void setDateplante(Date dateplante) {
	this.dateplante = dateplante;
}



public Date getDatereclote() {
	return datereclote;
}



public void setDatereclote(Date datereclote) {
	this.datereclote = datereclote;
}



public String getEtatdesante() {
	return etatdesante;
}



public void setEtatdesante(String etatdesante) {
	this.etatdesante = etatdesante;
}



public String getVitamine() {
	return vitamine;
}



public void setVitamine(String vitamine) {
	this.vitamine = vitamine;
}



public String getNomChamp() {
	return nomChamp;
}



public void setNomChamp(String nomChamp) {
	this.nomChamp = nomChamp;
}



public Float getPh() {
	return ph;
}



public void setPh(Float ph) {
	this.ph = ph;
}



public Session getSession() {
	return session;
}



public void setSession(Session session) {
	this.session = session;
}



public Rapportplante getRapportplante() {
	return rapportplante;
}



public void setRapportplante(Rapportplante rapportplante) {
	this.rapportplante = rapportplante;
}



@Override
public String toString() {
	return "Plante [Idplante=" + Idplante + ", nomplante=" + nomplante + ", typedesol=" + typedesol + ", dateplante="
			+ dateplante + ", datereclote=" + datereclote + ", etatdesante=" + etatdesante + ", vitamine=" + vitamine
			+ ", nomChamp=" + nomChamp + ", ph=" + ph + ", session=" + session + ", rapportplante=" + rapportplante
			+ "]";
}



public Plante(Long idplante, String nomplante, String typedesol, Date dateplante, Date datereclote, String etatdesante,
		String vitamine, String nomChamp, Float ph, Session session, Rapportplante rapportplante) {
	super();
	Idplante = idplante;
	this.nomplante = nomplante;
	this.typedesol = typedesol;
	this.dateplante = dateplante;
	this.datereclote = datereclote;
	this.etatdesante = etatdesante;
	this.vitamine = vitamine;
	this.nomChamp = nomChamp;
	this.ph = ph;
	this.session = session;
	this.rapportplante = rapportplante;
}



public Plante() {
	super();
	// TODO Auto-generated constructor stub
}



public void setDescription(String description) {
	// TODO Auto-generated method stub
	
}




    
   
	/*@ManyToMany
    @JoinTable(name = "PlanteChamp",joinColumns = @JoinColumn(name = "Idplante"),inverseJoinColumns = @JoinColumn(name = "Idchamp"))
    private List<Champ> listChamp = new ArrayList<>();*/


	

	
}
