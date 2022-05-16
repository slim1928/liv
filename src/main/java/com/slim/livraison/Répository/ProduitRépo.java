package com.slim.livraison.Répository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.slim.livraison.Model.ProduitEntity;



@Repository
public interface ProduitRépo extends JpaRepository<ProduitEntity, Long> {
	
	ProduitEntity findByRef(String ref);
	
	@Query("select p from ProduitEntity p where  p.ref like :x or p.designation like :x or p.poids like :x or p.quantite like :x ")
	public Page<ProduitEntity> findAllByMotCle( @Param("x")String mc, Pageable pageable );

	
}
