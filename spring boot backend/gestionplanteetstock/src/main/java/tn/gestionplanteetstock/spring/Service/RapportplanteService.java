package tn.gestionplanteetstock.spring.Service;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.gestionplanteetstock.spring.Entities.Plante;
//import tn.gestionplanteetstock.spring.Entities.Plante;
import tn.gestionplanteetstock.spring.Entities.Rapportplante;
import tn.gestionplanteetstock.spring.Entities.Session;
import tn.gestionplanteetstock.spring.Repository.PlanteRepository;
import tn.gestionplanteetstock.spring.Repository.RapportplanteRepository;



@Service
public class RapportplanteService  implements IRapportplanteService{
	
	@Autowired
	PlanteRepository planterep;
	
	@Autowired
	RapportplanteRepository rapportrep;

	
 public Rapportplante  addrapportplante(Rapportplante rapplant ) {
	 
	 rapportrep.save(rapplant);
	 
	 Plante plat= new Plante();
	 plat.setRapportplante(rapplant);
	 planterep.save(plat);
	 
	return null; 
	 
	}

 
	@Override
	public String addrapportbyexistance(Rapportplante rapplant) {
		// TODO Auto-generated method stub
		
		String ch="";
		if(rapportrep.existsBydescription(rapplant.getDescription())) {
			ch=("les donnees de authentification  est existe dans bd !!");
		}
		else
		{
			rapportrep.save(rapplant);
			
			 Plante plat= new Plante();
			 plat.setRapportplante(rapplant);
			 planterep.save(plat);
			 
			ch=("les donnees de authentification est ajouter dans bd !!");
		}
		return ch;
		
		
	}


	private void alert(String string) {
		// TODO Auto-generated method stub
		
	}



	  
	  
/*	  public Champ addrapportchamp(Long idrapportplante , Champ ch) {
		   
		  Rapportplante rap=rapportrep.findById(idrapportplante).get();
		  
		  ch.setRappplante(rap);
		return champrep.save(ch);*/
		  
	  }
