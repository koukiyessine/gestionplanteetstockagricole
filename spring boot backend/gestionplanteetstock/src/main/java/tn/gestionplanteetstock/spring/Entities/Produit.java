package tn.gestionplanteetstock.spring.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import tn.gestionplanteetstock.spring.Service.SessionService;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproduit;
    private String nomproduit;
    private Long referenceproduit;
    private Float quantitetotal;
    private Float quantitealerte;
    private int numtelephonefournisseur;
    private String img;

    @OneToOne
    private Session session;

    @ManyToOne
    private Rapportstock rapportstock;

    public Long getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Long idproduit) {
        this.idproduit = idproduit;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public Long getReferenceproduit() {
        return referenceproduit;
    }

    public void setReferenceproduit(Long referenceproduit) {
        this.referenceproduit = referenceproduit;
    }

    public Float getQuantitetotal() {
        return quantitetotal;
    }

    public void setQuantitetotal(Float quantitetotal) {
        this.quantitetotal = quantitetotal;
    }

    public Float getQuantitealerte() {
        return quantitealerte;
    }

    public void setQuantitealerte(Float quantitealerte) {
        this.quantitealerte = quantitealerte;
    }

    public int getNumtelephonefournisseur() {
        return numtelephonefournisseur;
    }

    public void setNumtelephonefournisseur(int numtelephonefournisseur) {
        this.numtelephonefournisseur = numtelephonefournisseur;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session sessionService) {
        this.session = sessionService;
    }

    public Rapportstock getRapportstock() {
        return rapportstock;
    }

    public void setRapportstock(Rapportstock rapportstock) {
        this.rapportstock = rapportstock;
    }

    // toString and constructors

    @Override
    public String toString() {
        return "Produit [idproduit=" + idproduit + ", nomproduit=" + nomproduit + ", referenceproduit="
                + referenceproduit + ", quantitetotal=" + quantitetotal + ", quantitealerte=" + quantitealerte
                + ", numtelephonefournisseur=" + numtelephonefournisseur + ", img=" + img + ", session=" + session
                + ", rapportstock=" + rapportstock + "]";
    }

    public Produit() {
        super();
    }

	public Produit(Long idproduit, String nomproduit, Long referenceproduit, Float quantitetotal, Float quantitealerte,
			int numtelephonefournisseur, String img, Session session, Rapportstock rapportstock) {
		super();
		this.idproduit = idproduit;
		this.nomproduit = nomproduit;
		this.referenceproduit = referenceproduit;
		this.quantitetotal = quantitetotal;
		this.quantitealerte = quantitealerte;
		this.numtelephonefournisseur = numtelephonefournisseur;
		this.img = img;
		this.session = session;
		this.rapportstock = rapportstock;
	}



	public void add(Produit produit) {
		// TODO Auto-generated method stub
		
	}

	public void add(Plante plante) {
		// TODO Auto-generated method stub
		
	}

	public void add(Rapportplante rapportPlante) {
		// TODO Auto-generated method stub
		
	}




}
 