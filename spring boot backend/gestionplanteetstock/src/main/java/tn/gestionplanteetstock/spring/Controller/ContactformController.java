package tn.gestionplanteetstock.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.gestionplanteetstock.spring.Entities.Contactform;
import tn.gestionplanteetstock.spring.Service.ContactformService;

@RestController
@RequestMapping("/api")
public class ContactformController {
	
	@Autowired
	
	ContactformService contserv;
	
	@PostMapping("/addContactform")
	public Contactform addContactform(@RequestBody  Contactform c) {
		return   contserv.addContactform(c);
	}

}
