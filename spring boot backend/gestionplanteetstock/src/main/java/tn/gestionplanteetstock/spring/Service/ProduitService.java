package tn.gestionplanteetstock.spring.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.gestionplanteetstock.spring.Entities.Plante;
//import tn.gestionplanteetstock.spring.Entities.Plante;
//import tn.gestionplanteetstock.spring.Entities.Plante;
import tn.gestionplanteetstock.spring.Entities.Produit;
import tn.gestionplanteetstock.spring.Entities.Rapportplante;
import tn.gestionplanteetstock.spring.Entities.Rapportstock;
import tn.gestionplanteetstock.spring.Repository.ProduitProjection;
import tn.gestionplanteetstock.spring.Repository.ProduitRepository;
import tn.gestionplanteetstock.spring.Repository.RapportstockRepository;


@Service
public class ProduitService  implements IProduitService {

@Autowired	
ProduitRepository prodrep;

@Autowired
RapportstockRepository rapportstockrep;




/*
@Override
public Produit addProduit(Produit p  ) {
	// TODO Auto-generated method stub
	return prodrep.save(p);
}
*/

@Override
public String addProduitbyexistance(Produit p) {
	// TODO Auto-generated method stub
	
	String ch="";
	if(prodrep.existsBynomproduit(p.getNomproduit()) && prodrep.existsByreferenceproduit(p.getReferenceproduit()) && 
			prodrep.existsByquantitealerte(p.getQuantitealerte())&& prodrep.existsByquantitetotal(p.getQuantitetotal())) {
		ch="les champs suivante already existe dans bd !!";
	}
	else
	{
		prodrep.save(p);
		ch="les champs suivante already  ajouter dans bd !!";
	}
	
	return ch;
}



@Override
public List<ProduitProjection> getallProduitByname( String nomproduit) {
	// TODO Auto-generated method stub
	return prodrep.listProduit(nomproduit);
}

@Override
public Produit UpdateProduit(Produit p, Long Idproduit) {
	// TODO Auto-generated method stub
	
       Produit pr = prodrep.findById(Idproduit).get();   
       
       pr.setNomproduit(p.getNomproduit());
       pr.setReferenceproduit(p.getReferenceproduit());
       pr.setQuantitetotal(p.getQuantitetotal());
       pr.setQuantitealerte(p.getQuantitealerte());
       pr.setNumtelephonefournisseur(p.getNumtelephonefournisseur());
       pr.setImg(p.getImg());
        
    
    return prodrep.save(pr);
}


@Override
public void deleteproduit(Long Idproduit) {
	// TODO Auto-generated method stub	
	prodrep.deleteById(Idproduit);
	
}



public List<ProduitProjection> getAllProduits() {   
    return prodrep.findAllBy();
}



/*
@Override
public Produit addfournisseurproduit(Produit p, Long idfournisseur) {
	// TODO Auto-generated method stub
	fournisseur fo=fourrep.findById(idfournisseur).get();
	p.setFournisseur(fo);
	
	return prodrep.save(p);  
}

*/

public List<String> getListNomProduitWithQuantiteTotal() {
    List<String> resultList = new ArrayList<>();

    List<Produit> produits = (List<Produit>) prodrep.findAll();

    for (Produit produit : produits) {
        if (produit.getNomproduit() != null && produit.getQuantitetotal() != null) {
            String nomProduitQuantiteTotal = produit.getNomproduit() + ": " + produit.getQuantitetotal();
            resultList.add(nomProduitQuantiteTotal);
        }
    }

    return resultList;
}




public List<String> getListNomProduitWithreferenceproduit() {
    List<String> resultList = new ArrayList<>();

    List<Produit> produits = (List<Produit>) prodrep.findAll();

    for (Produit produit : produits) {
        if (produit.getNomproduit() != null && produit.getReferenceproduit() != null) {
            String nomProduitreferenceproduit = produit.getNomproduit() + ": " + produit.getReferenceproduit();
            resultList.add(nomProduitreferenceproduit);
        }
    }

    return resultList;
}



public List<String> getListNomProduitWithquantitealerte() {
    List<String> resultList = new ArrayList<>();

    List<Produit> produits = (List<Produit>) prodrep.findAll();

    for (Produit produit : produits) {
        if (produit.getNomproduit() != null && produit.getQuantitealerte() != null) {
            String nomProduitquantitealerte = produit.getNomproduit() + ": " + produit.getQuantitealerte();
            resultList.add(nomProduitquantitealerte);
        }
    }

    return resultList;
}



public List<String> getListNomProduitWithnumtelephonefournisseur() {
    List<String> resultList = new ArrayList<>();

    List<Produit> produits = (List<Produit>) prodrep.findAll();

    for (Produit produit : produits) {
        if (produit.getNomproduit() != null && produit.getNumtelephonefournisseur() != 0) {
            String nomProduitnumtelephonefournisseur = produit.getNomproduit() + ": " + produit.getNumtelephonefournisseur();
            resultList.add(nomProduitnumtelephonefournisseur);
        }
    }

    return resultList;
}



/*
@Override
public List<Produit[]> getAllProduitData() {
	// TODO Auto-generated method stub
	return null;
}*/

}






