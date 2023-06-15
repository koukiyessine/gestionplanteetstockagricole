package tn.gestionplanteetstock.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.gestionplanteetstock.spring.Entities.Etatdesante;
import tn.gestionplanteetstock.spring.Entities.Humidity;
import tn.gestionplanteetstock.spring.Repository.EtatdesanteRepository;

@Service
public class EtatdesanteService implements IEtatdesanteService{

	
	@Autowired
	EtatdesanteRepository etatsanterep;
	
	
 	public List<Etatdesante> getAllEtatdesante(){
 	    return (List<Etatdesante>) etatsanterep.findAll();
 	}
	
	
}
