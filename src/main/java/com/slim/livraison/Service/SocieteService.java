package com.slim.livraison.Service;


import java.util.List;


import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.SocieteEntity;

public interface SocieteService {
	
	public SocieteEntity save(SocieteEntity societeEntity);
	
	public void delete(Long IdSociéte);
	
	SocieteEntity findByNom(String nom);
	
	SocieteEntity findById(Long IdSociéte);
	
	SocieteEntity update(SocieteEntity societeEntity,Long IdSociéte ) throws ResourceNotFoundException;
	
	List<SocieteEntity> FindAll();
	
	

	
}
