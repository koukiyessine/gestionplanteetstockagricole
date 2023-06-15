package tn.gestionplanteetstock.spring.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;

import tn.gestionplanteetstock.spring.Entities.Plante;
//import tn.gestionplanteetstock.spring.Entities.Produit;
//import tn.gestionplanteetstock.spring.Entities.Rapportplante;
//import tn.gestionplanteetstock.spring.Entities.Session;
import tn.gestionplanteetstock.spring.Repository.PlanteProjection;
import tn.gestionplanteetstock.spring.Repository.PlanteRepository;
//import tn.gestionplanteetstock.spring.Repository.ProduitProjection;
import tn.gestionplanteetstock.spring.Repository.RapportplanteRepository;
import tn.gestionplanteetstock.spring.Repository.SessionRepository;


@Service
public class PlanteService implements IPlanteService{

@Autowired
PlanteRepository plantrep;


@Autowired
SessionRepository sessiorep;

@Autowired
RapportplanteRepository rapportplant;
/*@Autowired
RoleRepository rolerep;*/

/*@Autowired
IchampRepository charep;*/



 /*	@Override
	public Plante addPlante(Plante p) {
		// TODO Auto-generated method stub
		return plantrep.save(p); 
	}
*/
 	
 	@Override
	public String addPlantebyexistance(Plante p) {
		// TODO Auto-generated method stub
		
		String ch="";
		if(plantrep.existsByEtatdesante(p.getEtatdesante()) && plantrep.existsByTypedesol(p.getTypedesol()) && 
				plantrep.existsByVitamine(p.getVitamine())&& plantrep.existsByNomplante(p.getNomplante())&&
				plantrep.existsByDateplante(p.getDateplante())&& plantrep.existsByDatereclote(p.getDatereclote())
				&& plantrep.existsBynomChamp(p.getNomChamp())&& plantrep.existsByph(p.getPh())) {
			
			ch="les champs suivante already existe dans bd !!";
		}
		else
		{
			plantrep.save(p);
			ch="les champs suivante already  ajouter dans bd !!";
		}
		
		return ch;
	}

 	
 	
 	public List<PlanteProjection> getAllplante() {
 	    return plantrep.findAllBy();
 	}

	@Override
	public Plante Updateplante(Plante p, Long Idplante) {
		// TODO Auto-generated method stub
		
		Plante pl=plantrep.findById(Idplante).get();
		pl.setNomplante(p.getNomplante());
		pl.setEtatdesante(p.getEtatdesante());
		pl.setTypedesol(p.getTypedesol());
		pl.setVitamine(p.getVitamine());
		pl.setDatereclote(p.getDatereclote());
		pl.setDateplante(p.getDateplante());
		pl.setNomChamp(p.getNomChamp());
		pl.setPh(p.getPh());	
		
		return plantrep.save(pl);
	}

	public void deletePlante(Long Idplante) {
		// TODO Auto-generated method stub
		
	plantrep.deleteById(Idplante);
		 
	}


	@Override
	public List<PlanteProjection> getallPlanteByname( String nomplante) {
		// TODO Auto-generated method stub
		return plantrep.listPlante(nomplante);
	}

	/*
	
	public Plante addsessionplante(Plante p , Long idsession) {
	    Session sess = sessiorep.findById(idsession).get();
	   
	        p.setSession(sess);
	      
	  
	    
	    return plantrep.save(p);
	}


*/
/*
	public Plante addSessionAndRapportPlante(Plante p, Long idsession, Long idrapportplante) {
	    Session sess = sessiorep.findById(idsession).orElseThrow(() -> new IllegalArgumentException("Session non trouvée"));
	    Rapportplante rplant = rapportplant.findById(idrapportplante).orElseThrow(() -> new IllegalArgumentException("Rapportplante non trouvé"));

	    p.setSession(sess);
	    p.setRapportplante(rplant);

	    return plantrep.save(p);
	}

*/


	
/*

	@Override
	public Plante addrapportPlante(Plante p, Long idrapportplante) {
		// TODO Auto-generated method stub
		
		Rapportplante rplant=rapportplant.findById(idrapportplante).get();
		
		p.setRapportplante(rplant);
		
		return plantrep.save(p);
	}
*/



/*
	public List<Plante> getallPlante() {
	    return (List<Plante>) plantrep.findAll();
	}
*/



	
	
/*	@Override
	public Plante addPlanteChamp(Long Idplante, Long Idchamp) {
		// TODO Auto-generated method stub
		
		Plante pl=plantrep.findById(Idplante).get();
		Champ ch=charep.findById(Idchamp).get();
		
		pl.addChamp(ch);
		return plantrep.save(pl);
	}


*/
	/*@Override
	public Plante addroleplante(Plante p, Long IdRole) {
		// TODO Auto-generated method stub
		Role ro=rolerep.findById(IdRole).get();
		p.setRole(ro);
		
		return plantrep.save(p);  
	}
*/



}
