package tn.gestionplanteetstock.spring.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import tn.gestionplanteetstock.spring.Entities.Produit;


public interface ProduitRepository extends  CrudRepository<Produit, Long> {

	
	Boolean existsBynomproduit(String nomproduit);
	Boolean existsByreferenceproduit(Long referenceproduit);
	Boolean existsByquantitetotal(Float quantitetotal);
	Boolean existsByquantitealerte(Float quantitealerte);
	
	
	 List<ProduitProjection> findAllBy();
	
	@Query(value="select  p.referenceproduit , p.quantitetotal , p.quantitealerte , p.numtelephonefournisseur, p.img from Produit p where p.nomproduit like :cle%",nativeQuery = true)
	List <ProduitProjection> listProduit(@Param("cle") String nomproduit);	
	
	
	
	
}
