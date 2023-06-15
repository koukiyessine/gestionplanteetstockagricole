package tn.gestionplanteetstock.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.gestionplanteetstock.spring.Entities.Rapportplante;



public interface RapportplanteRepository extends CrudRepository<Rapportplante, Long> {
	
	Boolean existsBydescription(String description);  

 
}
