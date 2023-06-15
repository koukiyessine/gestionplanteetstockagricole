package tn.gestionplanteetstock.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.gestionplanteetstock.spring.Entities.Etatdesante;
//import tn.gestionplanteetstock.spring.Entities.Quantiteeau;
import tn.gestionplanteetstock.spring.Repository.EtatdesanteRepository;
import tn.gestionplanteetstock.spring.Service.EtatdesanteService;

@RestController
@RequestMapping("/api")
public class EtatdesanteController {
	
	@Autowired
	EtatdesanteRepository etatsanterep;
	
	@Autowired
	EtatdesanteService etatsanteserv;
	
	
	
    @PostMapping("/addhealthstatus")
    public ResponseEntity<String> addHealthStatus(@RequestBody String plantHealthStatus) {
        Etatdesante etatdesante = new Etatdesante();
        etatdesante.setPlantHealthStatus(plantHealthStatus);
        etatsanterep.save(etatdesante);
        return ResponseEntity.ok("Données enregistrées avec succès !");
    }

	@GetMapping("/getAllEtatdesante")
    public List<Etatdesante> getAllEtatdesante(){
    	return etatsanteserv.getAllEtatdesante();
    }

}
