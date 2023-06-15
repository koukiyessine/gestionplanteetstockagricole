package tn.gestionplanteetstock.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.gestionplanteetstock.spring.Entities.Plante;
import tn.gestionplanteetstock.spring.Entities.Produit;
import tn.gestionplanteetstock.spring.Entities.Rapportstock;
import tn.gestionplanteetstock.spring.Repository.ProduitRepository;
import tn.gestionplanteetstock.spring.Repository.RapportstockRepository ;

@Service
public class RapportstockService  implements IRapportstock{
	@Autowired
	RapportstockRepository rapportstockrep;
	
	@Autowired
	ProduitRepository prodrep;
	
	@Override
	public String addrapportstockbyexistance(Rapportstock rapstock) {
		// TODO Auto-generated method stub
		
		String ch="";
		if(rapportstockrep.existsByDescriptionStock(rapstock.getDescriptionStock())) {
			ch=("les donnees de rapport stock  est existe dans bd !!");
		}
		else
		{
			rapportstockrep.save(rapstock);
			 Produit prod= new Produit();
			 prod.setRapportstock(rapstock);
			 prodrep.save(prod);
			ch=("les donnees de rapportstock est ajouter dans bd !!");
		}
		return ch;
		
		
	}

}
