package tn.gestionplanteetstock.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import tn.gestionplanteetstock.spring.Entities.Humidity;
import tn.gestionplanteetstock.spring.Entities.Quantiteeau;
import tn.gestionplanteetstock.spring.Repository.QuantiteeauRepository;
import tn.gestionplanteetstock.spring.Service.quantiteeauservice;

@RestController
@RequestMapping("/api")
public class QuantiteeauController {
	
	@Autowired
	QuantiteeauRepository quantiterep;
	
	
	@Autowired
	quantiteeauservice quantiteeauserv;
	/*@PostMapping("/addHumidityData")
	public ResponseEntity<String> addHumidityData(@RequestBody Quantiteeau humidity) {
	  // Traiter les données reçues
	  int humidityPer = humidity.getHumidity();

	  // Effectuer les opérations nécessaires avec les données d'humidité (par exemple, les enregistrer dans la base de données)
	  // ...

	  // Répondre avec un message de succès
	  return ResponseEntity.ok("Données d'humidité ajoutées avec succès");
	}*/
	
	@PostMapping("/addquantiteeau")
	public ResponseEntity<String> addquantiteeau(@RequestBody Quantiteeau humidity) {
		quantiterep.save(humidity);
	    return ResponseEntity.ok("Données enregistrées avec succès !");
	}

	@GetMapping("/getAllQuantiteeau")
	public List<Quantiteeau> getAllQuantiteeau(){
		return quantiteeauserv.getAllQuantiteeau();
	}
	

	
}
