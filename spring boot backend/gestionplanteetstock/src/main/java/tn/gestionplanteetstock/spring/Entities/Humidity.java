package tn.gestionplanteetstock.spring.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Humidity {
	
	@Id     
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long IdHumd;
	private int soilMoisture;
	
	public Long getIdHumd() {
		return IdHumd;
	}
	
	public void setIdHumd(Long idHumd) {
		IdHumd = idHumd;
	}
	
	public int getSoilMoisture() {
		return soilMoisture;
	}
	
	public void setSoilMoisture(int soilMoisture) {
		this.soilMoisture = soilMoisture;
	}
	
	@Override
	public String toString() {
		return "Humidity [IdHumd=" + IdHumd + ", soilMoisture=" + soilMoisture + "]";
	}

	
	public Humidity(Long idHumd, int soilMoisture) {
		super();
		IdHumd = idHumd;
		this.soilMoisture = soilMoisture;
	}

	
	
	public Humidity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


	
	
	
	
	

}
