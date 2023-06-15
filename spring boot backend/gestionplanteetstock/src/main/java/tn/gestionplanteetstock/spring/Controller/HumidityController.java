package tn.gestionplanteetstock.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.gestionplanteetstock.spring.Entities.Humidity;
//import tn.gestionplanteetstock.spring.Entities.Temperature;
import tn.gestionplanteetstock.spring.Repository.HumidityRepository;
import tn.gestionplanteetstock.spring.Service.HumidityService;

@RestController
@RequestMapping("/api")
public class HumidityController {

	@Autowired
	HumidityRepository humidrep;
	
	@Autowired 
	HumidityService humidserv;
	
	@PostMapping("/datahumidity")
	public ResponseEntity<String> datahumidity(@RequestBody Humidity soilMoisture) {
	    humidrep.save(soilMoisture);
	    return ResponseEntity.ok("Données enregistrées avec succès !");
	}
	
	@GetMapping("/getAllHumidity")
	public List<Humidity> getAllHumidity(){
		return humidserv.getAllHumidity();
	}

}
