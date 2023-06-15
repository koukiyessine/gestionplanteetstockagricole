package tn.gestionplanteetstock.spring.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import tn.gestionplanteetstock.spring.Entities.Humidity;
import tn.gestionplanteetstock.spring.Entities.Weather;
import tn.gestionplanteetstock.spring.Repository.WeatherRepository;

@Service
public class WeatherService implements IWeatherService {
	
	@Autowired
	WeatherRepository weatherrep;

	public List<Weather> getAllWeather() {
	    List<Weather> allWeather = (List<Weather>) weatherrep.findAll();
	    List<Weather> filteredWeather = new ArrayList<>();

	    for (Weather weather : allWeather) {
	        if (weather.getTemperature() != 0 && weather.getHumidity() != 0) {
	            filteredWeather.add(weather);
	        }
	    }

	    return filteredWeather;
	}


}
