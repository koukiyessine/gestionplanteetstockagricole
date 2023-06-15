package tn.gestionplanteetstock.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.gestionplanteetstock.spring.Entities.Weather;

public interface WeatherRepository extends CrudRepository<Weather, Long> {

}
