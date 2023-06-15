package tn.gestionplanteetstock.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.gestionplanteetstock.spring.Entities.Rapportstock;
import tn.gestionplanteetstock.spring.Service.RapportstockService;

@RestController
@RequestMapping("/api")
public class RapportstockController {
	
	@Autowired
	RapportstockService rapstockserv;
	
	@PostMapping("/addrapportstockbyexistance")
	public String addrapportstockbyexistance(@RequestBody Rapportstock rapstock) {
		 return rapstockserv.addrapportstockbyexistance(rapstock);
		 
	 }


}
