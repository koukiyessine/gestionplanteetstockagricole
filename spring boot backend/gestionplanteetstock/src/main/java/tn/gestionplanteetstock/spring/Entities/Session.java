package tn.gestionplanteetstock.spring.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsession;
    private String email;
    private String password;
    private String selectedOption;

    @OneToOne(mappedBy = "session", cascade = CascadeType.ALL)
   
    private Rapportplante rapportPlante;

    @OneToOne(mappedBy = "session", cascade = CascadeType.ALL)
    private Rapportstock rapportStock;

    @OneToOne(mappedBy = "session", cascade = CascadeType.ALL)
    private Produit produit;

    @OneToOne(mappedBy = "session", cascade = CascadeType.ALL)
    private Plante plante;

   
  

    // Getters and Setters

    public Long getIdsession() {
        return idsession;
    }

    public void setIdsession(Long idsession) {
        this.idsession = idsession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public Rapportplante getRapportPlante() {
        return rapportPlante;
    }

    public void setRapportPlante(Rapportplante rapportPlante) {
        this.rapportPlante = rapportPlante;
    }

    public Rapportstock getRapportStock() {
        return rapportStock;
    }

    public void setRapportStock(Rapportstock rapportStock) {
        this.rapportStock = rapportStock;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Plante getPlante() {
        return plante;
    }

    public void setPlante(Plante plante) {
        this.plante = plante;
    }

    // toString and constructors

    @Override
    public String toString() {
        return "Session [idsession=" + idsession + ", email=" + email + ", password=" + password + ", selectedOption="
                + selectedOption + ", rapportPlante=" + rapportPlante + ", rapportStock=" + rapportStock + ", produit="
                + produit + ", plante=" + plante + "]";
    }	



    public Session(Long idsession, String email, String password, String selectedOption, Rapportplante rapportPlante,
            Rapportstock rapportStock, Produit produit, Plante plante) {
        super();
        this.idsession = idsession;
        this.email = email;
        this.password = password;
        this.selectedOption = selectedOption;
        this.rapportPlante = rapportPlante;
        this.rapportStock = rapportStock;
        this.produit = produit;
        this.plante = plante;
    }

    public Session() {
        super();
    }


}