package tn.gestionplanteetstock.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.gestionplanteetstock.spring.Entities.Rapportstock;

public interface RapportstockRepository extends CrudRepository<Rapportstock , Long> {

	boolean existsByDescriptionStock(String descriptionStock);

}
