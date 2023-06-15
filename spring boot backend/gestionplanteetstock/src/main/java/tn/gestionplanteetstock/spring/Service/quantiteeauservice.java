package tn.gestionplanteetstock.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import tn.gestionplanteetstock.spring.Entities.Humidity;
import tn.gestionplanteetstock.spring.Entities.Quantiteeau;
import tn.gestionplanteetstock.spring.Repository.QuantiteeauRepository;

@Service
public class quantiteeauservice  implements Iquantiteeauservice{

	
	@Autowired
	QuantiteeauRepository quantiterep;
	
 	public List<Quantiteeau> getAllQuantiteeau(){
 	    return (List<Quantiteeau>) quantiterep.findAll();
 	}
}
