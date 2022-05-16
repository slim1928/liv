package com.slim.livraison.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.LigneFactureEntity;


public interface LigneFactService {

	
	LigneFactureEntity save(LigneFactureEntity ligneFactureEntity);
	
	List<LigneFactureEntity> getAll(Long id);
	
	LigneFactureEntity update(LigneFactureEntity ligneFactureEntity,Long id ) throws ResourceNotFoundException;
	
	public void delete(Long id);
	
	Optional<LigneFactureEntity> FindById(Long id);
	
	public Page<LigneFactureEntity> getLignesFacture(Date d1, Date d2);
	
}
