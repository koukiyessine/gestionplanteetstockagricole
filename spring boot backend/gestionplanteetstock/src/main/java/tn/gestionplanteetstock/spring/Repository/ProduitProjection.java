package tn.gestionplanteetstock.spring.Repository;



public interface ProduitProjection {
	String getNomproduit();
	Long getReferenceproduit();
	Float getQuantitetotal();
	Float getQuantitealerte() ;
	int getNumtelephonefournisseur();
	String getImg() ;
}
