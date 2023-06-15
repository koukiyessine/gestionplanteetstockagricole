package tn.gestionplanteetstock.spring.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Weather {

	@Id     
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long IdWeather;
	private float temperature;
	private float humidity;
	
	public Long getIdWeather() {
		return IdWeather;
	}
	public void setIdWeather(Long idWeather) {
		IdWeather = idWeather;
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	
	@Override
	public String toString() {
		return "Weather [IdWeather=" + IdWeather + ", temperature=" + temperature + ", humidity=" + humidity + "]";
	}
	
	
	public Weather(Long idWeather, float temperature, float humidity) {
		super();
		IdWeather = idWeather;
		this.temperature = temperature;
		this.humidity = humidity;
	}
	
	public Weather() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*public int getVariable() {
		// TODO Auto-generated method stub
		return 0;
	}
	*/
	
	
	
	
	
	
	
	
}
