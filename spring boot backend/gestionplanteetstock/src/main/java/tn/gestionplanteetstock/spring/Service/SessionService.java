package tn.gestionplanteetstock.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.gestionplanteetstock.spring.Entities.Plante;
import tn.gestionplanteetstock.spring.Entities.Produit;
import tn.gestionplanteetstock.spring.Entities.Rapportplante;
import tn.gestionplanteetstock.spring.Entities.Rapportstock;
import tn.gestionplanteetstock.spring.Entities.Session;
import tn.gestionplanteetstock.spring.Repository.PlanteRepository;
import tn.gestionplanteetstock.spring.Repository.ProduitRepository;
import tn.gestionplanteetstock.spring.Repository.RapportplanteRepository;
import tn.gestionplanteetstock.spring.Repository.RapportstockRepository;
import tn.gestionplanteetstock.spring.Repository.SessionRepository;




@Service 
public class SessionService implements ISessionService {

	@Autowired
	SessionRepository sessionrep;
	

	      @Autowired
	     ProduitRepository produitRepository;

	    @Autowired
        PlanteRepository planteRepository;

	    @Autowired
	     RapportplanteRepository rapportPlanteRepository;

	    @Autowired
	     RapportstockRepository rapportStockRepository;

	    /*
	    public void processSelectedOption(Session session) {
	        String selectedOption = session.getSelectedOption();

	        if (selectedOption != null) {
	            if (selectedOption.equals("responsable")) {
	                Produit produit = new Produit();
	                produit.setSession(session);
	                session.getProduit().add(produit); // Ajoute le produit à la liste des produits de la session
	                sessionrep.save(session); // Sauvegarde la session en base de données

	                Plante plante = new Plante();
	                plante.setSession(session);
	                session.getPlantes().add(plante); // Ajoute la plante à la liste des plantes de la session
	                sessionrep.save(session); // Sauvegarde la session en base de données
	            } else if (selectedOption.equals("Agriculteur")) {
	                Rapportplante rapportPlante = new Rapportplante();
	                rapportPlante.setSession(session);
	                session.getPlantes().add(rapportPlante); // Ajoute le rapportPlante à la liste des rapports de plantes de la session
	                sessionrep.save(session); // Sauvegarde la session en base de données

	                Rapportstock rapportStock = new Rapportstock();
	                rapportStock.setSession(session);
	                session.getRapportStock().add(rapportStock); // Ajoute le rapportStock à la liste des rapports de stock de la session
	                sessionrep.save(session); // Sauvegarde la session en base de données
	            } else {
	                throw new IllegalArgumentException("Option invalide");
	            }
	        } else {
	            throw new IllegalArgumentException("Option invalide");
	        }
	    }

*/
	 
	    public Session addSession(Session s) {
	        // Sauvegarder la session en base de données
	        Session savedSession = sessionrep.save(s);

	        if ("responsable".equals(s.getSelectedOption())) {
	            // Créer et associer un produit à la session
	            Produit prod = new Produit();
	            prod.setSession(savedSession);
	            produitRepository.save(prod);

	            // Créer et associer une plante à la session
	            Plante plat = new Plante();
	            plat.setSession(savedSession);
	            planteRepository.save(plat);
	        } else if ("Agriculteur".equals(s.getSelectedOption())) {
	            // Créer et associer un rapportplante à la session
	            Rapportplante raplant = new Rapportplante();
	            raplant.setSession(savedSession);
	            rapportPlanteRepository.save(raplant);

	            // Créer et associer un rapportstock à la session
	            Rapportstock rastock = new Rapportstock();
	            rastock.setSession(savedSession);
	            rapportStockRepository.save(rastock);
	        }

	        return savedSession;
	    }

	
	

	@Override
	public String addsessionbyexistance(Session s) {
		// TODO Auto-generated method stub
		
		String ch="";
		if(sessionrep.existsBypassword(s.getPassword()) && sessionrep.existsByemail(s.getEmail()) &&
				sessionrep.existsByselectedOption(s.getSelectedOption())) {
			ch=("les donnees de authentification  est existe dans bd !!");
		}
		else
		{
			
		       Session savedSession = sessionrep.save(s);

		        if ("responsable".equals(s.getSelectedOption())) {
		            // Créer et associer un produit à la session
		            Produit prod = new Produit();
		            prod.setSession(savedSession);
		            produitRepository.save(prod);

		            // Créer et associer une plante à la session
		            Plante plat = new Plante();
		            plat.setSession(savedSession);
		            planteRepository.save(plat);
		            
		        } else if ("Agriculteur".equals(s.getSelectedOption())) {
		            // Créer et associer un rapportplante à la session
		            Rapportplante raplant = new Rapportplante();
		            raplant.setSession(savedSession);
		            rapportPlanteRepository.save(raplant);

		            // Créer et associer un rapportstock à la session
		            Rapportstock rastock = new Rapportstock();
		            rastock.setSession(savedSession);
		            rapportStockRepository.save(rastock);
		        }

		        
			ch=("les donnees de authentification est ajouter dans bd !!");
		}
		return ch;
		
		
	}


    public long getTotalRows() {
        return sessionrep.count();
    }




	//@Override
/*	public Session addSessionrole(Long Idsession, Long IdRole) {
		// TODO Auto-generated method stub
		
		Session se=sessionrep.findById(Idsession).get();
		Role ro=rolerep.findById(IdRole).get();
		
		se.addRole(ro);
		return sessionrep.save(se);
	}*/
	
	}



