package tn.gestionplanteetstock.spring.Service;



import java.util.List;



import tn.gestionplanteetstock.spring.Entities.Plante;
//import tn.gestionplanteetstock.spring.Entities.Rapportplante;
//import tn.gestionplanteetstock.spring.Entities.Session;
import tn.gestionplanteetstock.spring.Entities.Rapportplante;
import tn.gestionplanteetstock.spring.Repository.PlanteProjection;

public interface IPlanteService  {

	//public Plante addsessionplante(Plante p);


	public String addPlantebyexistance(Plante p);
	public Plante Updateplante(Plante p , Long Idplante);
	void deletePlante(Long Idplante);
	public List<PlanteProjection> getallPlanteByname(String ch);
	public List<PlanteProjection> getAllplante();
//	public Plante addsessionplante(Plante p , Long idsession);
	
/*	public List<Plante> getallPlanteByname(String ch);
//	Plante addPlanteChamp(Long Idplante, Long Idchamp);
	
	public Plante addroleplante(Plante p ,Long IdRole);*/
}
