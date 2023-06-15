package tn.gestionplanteetstock.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.gestionplanteetstock.spring.Entities.Temperature;

public interface TemperatureRepository extends CrudRepository<Temperature, Long> {
	
	

}
