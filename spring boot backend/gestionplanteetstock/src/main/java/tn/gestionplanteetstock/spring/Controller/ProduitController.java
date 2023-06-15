package tn.gestionplanteetstock.spring.Controller;

import java.util.ArrayList;
import java.util.List;

//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.gestionplanteetstock.spring.Entities.Produit;
import tn.gestionplanteetstock.spring.Repository.ProduitProjection;
import tn.gestionplanteetstock.spring.Service.ProduitService;

@RestController
@RequestMapping("/api")
public class ProduitController {

@Autowired
ProduitService prodServ;


@GetMapping("/getallProduitByname/{nomproduit}")
public List<ProduitProjection> getallProduitByname(@PathVariable String nomproduit){
	return  prodServ.getallProduitByname(nomproduit);
	
}



@PostMapping("/addProduitbyexistance")
public String addProduitbyexistance(@RequestBody Produit p){
	 return prodServ.addProduitbyexistance(p);
}



@PostMapping("/updateProduit/{Idproduit}")
public Produit UpdateProduit(@RequestBody Produit p ,@PathVariable  Long Idproduit){
	 return prodServ.UpdateProduit(p, Idproduit);
}



@DeleteMapping("/deleteProduit/{Idproduit}")
public void deleteProduit(@PathVariable Long Idproduit) {
	prodServ.deleteproduit(Idproduit);
}

@GetMapping("/getAllProduits")
public List<ProduitProjection> getAllProduits() {
    List<ProduitProjection> produits = prodServ.getAllProduits();
    List<ProduitProjection> filteredProduits = new ArrayList<>();

    for (ProduitProjection produit : produits) {
        // Vérifier si les attributs requis ne sont pas null ou zéro
        if (produit.getNomproduit() != null && produit.getReferenceproduit() != null &&
            produit.getQuantitetotal() != null && produit.getQuantitealerte() != null &&
            produit.getNumtelephonefournisseur() != 0 && produit.getImg() != null) {
            filteredProduits.add(produit);
        }
    }

    return filteredProduits;
}



@GetMapping("/getListNomProduitWithQuantiteTotal")
public List<String> getListNomProduitWithQuantiteTotal() {
	return  prodServ.getListNomProduitWithQuantiteTotal();
}


@GetMapping("/getListNomProduitWithreferenceproduit")
public List<String> getListNomProduitWithreferenceproduit(){
	return  prodServ.getListNomProduitWithreferenceproduit();

}


@GetMapping("/getListNomProduitWithquantitealerte")
public List<String> getListNomProduitWithquantitealerte(){
	return prodServ.getListNomProduitWithquantitealerte();
}


@GetMapping("/getListNomProduitWithnumtelephonefournisseur")
public List<String> getListNomProduitWithnumtelephonefournisseur(){
	return prodServ.getListNomProduitWithnumtelephonefournisseur();
}
/*

@PostMapping("/addfournisseurproduit/{idfournisseur}")
public Produit addfournisseurproduit(@RequestBody Produit p,@PathVariable Long idfournisseur) {
	return prodServ.addfournisseurproduit(p, idfournisseur);
}

*/
}
