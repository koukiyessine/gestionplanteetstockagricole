package tn.gestionplanteetstock.spring.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etatdesante {
	@Id     
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long IdEtatdesante;
	private String plantHealthStatus;
	
	
	public Long getIdEtatdesante() {
		return IdEtatdesante;
	}
	public void setIdEtatdesante(Long idEtatdesante) {
		IdEtatdesante = idEtatdesante;
	}
	public String getPlantHealthStatus() {
		return plantHealthStatus;
	}
	public void setPlantHealthStatus(String plantHealthStatus) {
		this.plantHealthStatus = plantHealthStatus;
	}
	
	@Override
	public String toString() {
		return "Etatdesante [IdEtatdesante=" + IdEtatdesante + ", plantHealthStatus=" + plantHealthStatus + "]";
	}
	
	
	public Etatdesante(Long idEtatdesante, String plantHealthStatus) {
		super();
		IdEtatdesante = idEtatdesante;
		this.plantHealthStatus = plantHealthStatus;
	}
	
	
	public Etatdesante() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
