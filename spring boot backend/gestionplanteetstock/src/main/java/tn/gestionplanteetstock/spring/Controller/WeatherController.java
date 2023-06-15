package tn.gestionplanteetstock.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import tn.gestionplanteetstock.spring.Entities.Quantiteeau;
//import tn.gestionplanteetstock.spring.Entities.Humidity;
import tn.gestionplanteetstock.spring.Entities.Weather;
import tn.gestionplanteetstock.spring.Repository.WeatherRepository;
import tn.gestionplanteetstock.spring.Service.WeatherService;

@RestController
@RequestMapping("/api")
public class WeatherController {
	
	@Autowired
	WeatherRepository weatherrep;

	                                                 
	@Autowired
	WeatherService weatherserv;
	
	@PostMapping("/addweather")
	public ResponseEntity<String> addweather(@RequestBody Weather temperature ,Weather humidity) {
		weatherrep.save(temperature);
		weatherrep.save(humidity);
	    return ResponseEntity.ok("Données enregistrées avec succès !");
	}
	
	
	
	@GetMapping("/getAllWeather")
	public List<Weather> getAllWeather(){
		return weatherserv.getAllWeather();
	}
	
	
	
	
}
