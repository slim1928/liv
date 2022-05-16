package com.slim.livraison.Répository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slim.livraison.Model.SocieteEntity;

@Repository
public interface SocieteRépo extends JpaRepository<SocieteEntity, Long> {
	
	SocieteEntity findByNom(String nom);
	

}
