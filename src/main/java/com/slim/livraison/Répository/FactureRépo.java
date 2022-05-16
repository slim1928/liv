package com.slim.livraison.Répository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.slim.livraison.Model.FactureEntity;


@Repository
public interface FactureRépo extends JpaRepository<FactureEntity, Long> {

	@Query("select p from FactureEntity p where p.dateFacture=:x and p.numero=:num")
	public Page<FactureEntity> findAllFacturesClients(@Param("num")Long numero,@Param("x")Date date,Pageable pageable);
	  
	
	@Query("select p from FactureEntity p where p.clients.id=:x and p.numero=:num")
	public Page<FactureEntity> findAllFacturesOfClient(@Param("num")Long numero,@Param("x")Long id, Pageable pageable);
 
	@Query("select p from FactureEntity p where p.clients.id=:x and p.dateFacture=:d and p.numero=:num")
	public Page<FactureEntity> findAllFacturesOfClient(@Param("num")Long numero,@Param("x")Long id,@Param("d")Date date, Pageable pageable);


	
 
	
}
