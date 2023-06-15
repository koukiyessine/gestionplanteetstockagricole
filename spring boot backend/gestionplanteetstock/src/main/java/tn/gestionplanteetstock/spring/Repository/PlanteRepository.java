package tn.gestionplanteetstock.spring.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.gestionplanteetstock.spring.Entities.Plante;

public interface PlanteRepository extends CrudRepository<Plante, Long> {
	
	Boolean existsByEtatdesante(String Etatdesante);
	Boolean existsByTypedesol(String Typedesol);
	Boolean existsByVitamine(String Vitamine);
	Boolean existsByNomplante(String Nomplante);
	Boolean existsByDateplante(Date Dateplante);
	Boolean existsByDatereclote(Date datereclote);
	Boolean existsBynomChamp(String nomChamp);
	Boolean existsByph(Float ph);
	
	
	@Query(value = "SELECT * FROM Plante p WHERE p.nomplante LIKE :cle%", nativeQuery = true)
	List<PlanteProjection> listPlante(@Param("cle") String nomplante);



	List<PlanteProjection> findAllBy();
}
