package tn.gestionplanteetstock.spring.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.gestionplanteetstock.spring.Entities.Quantiteeau;

@Service
public interface Iquantiteeauservice {
	
	public List<Quantiteeau> getAllQuantiteeau();

}
