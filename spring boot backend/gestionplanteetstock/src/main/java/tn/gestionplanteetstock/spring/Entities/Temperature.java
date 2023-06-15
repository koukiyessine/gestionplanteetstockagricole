package tn.gestionplanteetstock.spring.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Temperature {
	
@Id     
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long IdTemp;
private float value;


public Long getIdTemp() {
	return IdTemp;
}
public void setIdTemp(Long idTemp) {
	IdTemp = idTemp;
}
public float getValue() {
	return value;
}
public void setValue(float value) {
	this.value = value;
}


@Override
public String toString() {
	return "Temperature [IdTemp=" + IdTemp + ", value=" + value + "]";
}


public Temperature(Long idTemp, float value) {
	super();
	IdTemp = idTemp;
	this.value = value;
}


public Temperature() {
	super();
	// TODO Auto-generated constructor stub
}


	
}
