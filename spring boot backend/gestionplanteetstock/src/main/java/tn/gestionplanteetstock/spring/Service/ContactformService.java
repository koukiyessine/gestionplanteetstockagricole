package tn.gestionplanteetstock.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.gestionplanteetstock.spring.Entities.Contactform;
import tn.gestionplanteetstock.spring.Repository.ContactformRepository;

@Service
public class ContactformService implements IContactformService {
	
	@Autowired
	ContactformRepository contactrep;

	@Override
	public Contactform addContactform(Contactform c) {
	    // Vérifier les champs obligatoires
	    if (c.getName() == null || c.getEmail() == null || c.getSubject() == null || c.getMessage() == null) {
	        throw new IllegalArgumentException("Tous les champs doivent être renseignés");
	    }

	    // Enregistrer l'objet Contactform s'il passe la vérification
	    return contactrep.save(c);
	}


}
