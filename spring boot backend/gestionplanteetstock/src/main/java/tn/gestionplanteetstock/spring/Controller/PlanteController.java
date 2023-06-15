package tn.gestionplanteetstock.spring.Controller;

import java.util.ArrayList;
import java.util.List;

//import javax.websocket.server.PathParam;

//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.gestionplanteetstock.spring.Entities.Plante;
import tn.gestionplanteetstock.spring.Repository.PlanteProjection;
import tn.gestionplanteetstock.spring.Service.PlanteService;


@RestController
@RequestMapping("/api")
public class PlanteController {

 @Autowired
 PlanteService planteserv;
 
   /* @PostMapping("/addsessionplante/{ids}")
	public Plante addsessionplante(@RequestBody Plante p ,@PathVariable("ids") Long idsession ) {
    	return planteserv.addsessionplante(p,idsession);
		
	}*/
/*
 @PostMapping("/addrapportPlante/{idr}")
	public Plante addrapportPlante(@RequestBody Plante p,@PathVariable("idr") Long idrapportplante) {
	return  planteserv.addrapportPlante( p, idrapportplante);
}*/
 
 @PostMapping("/addPlantebyexistance")
 public String addsessionbyexistance(@RequestBody Plante p){
 	 return planteserv.addPlantebyexistance(p);
 }
 
 
 
 @PostMapping("/Updateplante/{Idplante}")
 public Plante Updateplante(@RequestBody Plante p ,@PathVariable Long Idplante){
 	 return planteserv.Updateplante(p, Idplante);
 }
 
 
 @DeleteMapping("/deletePlante/{Idplante}")
 public void deletePlante(@PathVariable  Long Idplante) {
	 planteserv.deletePlante(Idplante);
 }
 
      @GetMapping("/getallPlanteByname/{nomplante}")
    
	public List<PlanteProjection> getallPlanteByname( @PathVariable  String nomplante) {		
		return planteserv.getallPlanteByname(nomplante);
	}
      
      
      @GetMapping("/getAllplante")
      public List<PlanteProjection> getAllplante() {
          List<PlanteProjection> plantes = planteserv.getAllplante();
          List<PlanteProjection> filteredPlantes = new ArrayList<>();

          for (PlanteProjection plante : plantes) {
              // Vérifier si les attributs requis ne sont pas null ou zéro
              if (plante.getNomplante() != null && plante.getTypedesol() != null &&
                  plante.getDateplante() != null && plante.getDatereclote() != null &&
                  plante.getEtatdesante() != null && plante.getVitamine() != null && plante.getNomChamp() != null && 
                  plante.getPh() != 0){
                  filteredPlantes.add(plante);
              }
          }

          return filteredPlantes;
      }

     /* @PostMapping("/addPlanteChamp/{Idplante}/{idChamp}")
      public Plante addPlanteChamp(@PathVariable Long Idplante,@PathVariable Long idChamp) {
    	  return planteserv.addPlanteChamp(Idplante, idChamp);
      }
      
      @PostMapping("/addroleplante/{IdRole}")
  	public Plante addroleplante(@RequestBody Plante p,@PathVariable Long IdRole) {
    	  return planteserv.addroleplante(p, IdRole) ;
      }
      */
      
      
 
  }
 


