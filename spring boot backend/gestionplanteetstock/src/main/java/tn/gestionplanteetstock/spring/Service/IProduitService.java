package tn.gestionplanteetstock.spring.Service;

import java.util.List;

import tn.gestionplanteetstock.spring.Entities.Produit;
import tn.gestionplanteetstock.spring.Repository.ProduitProjection;

public interface IProduitService {

	// public Produit addProduit(Produit p);
	
     public String addProduitbyexistance(Produit p);
	 public  void deleteproduit(Long idproduit);
	
	public Produit UpdateProduit(Produit p, Long Idproduit);
	
	//public Produit addfournisseurproduit(Produit p, Long idfournisseur);
	//public Produit addProduit(Produit p, Long idRapportstock);
	
	public List<ProduitProjection> getallProduitByname(String nomproduit);
//	public List<Produit> getallProduit();
	public List<String> getListNomProduitWithQuantiteTotal();
	
	public List<String> getListNomProduitWithreferenceproduit();
	public List<String> getListNomProduitWithquantitealerte();
	public List<String> getListNomProduitWithnumtelephonefournisseur();

	
	public List<ProduitProjection> getAllProduits();
	
}
