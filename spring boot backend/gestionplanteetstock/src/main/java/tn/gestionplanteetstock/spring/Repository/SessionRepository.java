package tn.gestionplanteetstock.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.gestionplanteetstock.spring.Entities.Session;

public interface SessionRepository extends CrudRepository<Session, Long> {

Boolean existsBypassword(String password);
Boolean existsByemail(String email);    
Boolean existsByselectedOption(String selectedOption);
Session findBySelectedOption(String string);




	
}
