package com.slim.livraison.Répository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.slim.livraison.Model.ChauffeurEntity;



@Repository
public interface ChauffeurRépo extends JpaRepository<ChauffeurEntity, Long> {

	ChauffeurEntity findByNom(String nom);
	
	@Query("select p from ChauffeurEntity p where p.nom like :x or p.username like :x or p.email like :x or p.tel like :x")
	public Page<ChauffeurEntity> findAllByMotCle( @Param("x")String mc, Pageable pageable );
}
