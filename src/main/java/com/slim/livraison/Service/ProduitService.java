package com.slim.livraison.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import org.springframework.data.repository.query.Param;

import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.ProduitEntity;




public interface ProduitService {


	ProduitEntity findByRef(String ref);
	
    public ProduitEntity save(ProduitEntity produitEntity);
	
	public void delete(Long Id);
	
	ProduitEntity findById(Long Id);
	
	ProduitEntity updateProduit(ProduitEntity produitEntity, Long Id) throws ResourceNotFoundException;
	
	List<ProduitEntity> FindAll();
	
	public Page<ProduitEntity> findAllByMotCle( @Param("x")String mc, int page, int size );
}
