package tn.gestionplanteetstock.spring.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.gestionplanteetstock.spring.Entities.Temperature;
import tn.gestionplanteetstock.spring.Repository.TemperatureRepository;
import tn.gestionplanteetstock.spring.Service.TemperatureService;

@RestController
@RequestMapping("/api")

public class TemperatureController {
	
	@Autowired
	TemperatureRepository temprep;
	
	@Autowired
	TemperatureService tempserv;
	
	@PostMapping("/receiveData")
	public ResponseEntity<String> receiveData(@RequestBody Temperature value) {
		temprep.save(value);
		return ResponseEntity.ok("Données enregistrées avec succès !");
	}
	
	
	@GetMapping("/getalltemperature")
	
 	public List<Temperature> getAlltemperature() {
		return tempserv.getAlltemperature();
				
		
	}

	
}

