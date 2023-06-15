package tn.gestionplanteetstock.spring.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quantiteeau {
	
	@Id     
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long Idquantiteeau;
	private int humidity;
	
	
	public Long getIdquantiteeau() {
		return Idquantiteeau;
	}
	public void setIdquantiteeau(Long idquantiteeau) {
		Idquantiteeau = idquantiteeau;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	
	
	@Override
	public String toString() {
		return "quantiteeau [Idquantiteeau=" + Idquantiteeau + ", humidity=" + humidity + "]";
	}
	public Quantiteeau(Long idquantiteeau, int humidity) {
		super();
		Idquantiteeau = idquantiteeau;
		this.humidity = humidity;
	}
	
	
	public Quantiteeau() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
