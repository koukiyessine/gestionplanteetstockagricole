package tn.gestionplanteetstock.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.gestionplanteetstock.spring.Entities.Rapportplante;
import tn.gestionplanteetstock.spring.Service.RapportplanteService;

@RestController
@RequestMapping("/api")
public class Rapportplantecontroller {
	
	@Autowired
	RapportplanteService rapportserv;
	

	 @PostMapping("/addrapportplante")
	 public Rapportplante  addrapportplante(@RequestBody Rapportplante rapplant ) {
		 return  rapportserv.addrapportplante(rapplant);
    }
    
	 @PostMapping("/addrapportbyexistance")
	 public String  addrapportbyexistance(@RequestBody Rapportplante rapplant) {
		 return  rapportserv.addrapportbyexistance(rapplant);
    }
    
	 
	 
    
      /*  @PostMapping("/rapportplante/{idrapportplante}")

  	  public Champ addrapportchamp(@PathVariable Long idrapportplante ,@RequestBody Champ ch) {
          return rapportserv.addrapportchamp(idrapportplante, ch);
    }*/

}
