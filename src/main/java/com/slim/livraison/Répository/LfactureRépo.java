package com.slim.livraison.Répository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.slim.livraison.Model.LigneFactureEntity;



@Repository
public interface LfactureRépo extends JpaRepository<LigneFactureEntity, Long> {

	
	@Query("select lf from LigneFactureEntity lf where lf.facture.dateFacture between :d1 and :d2 "
			+ "group by lf.produit order by lf.qte desc")
	public Page<LigneFactureEntity> findAllBetween(@Param("d1")Date d1,@Param("d2")Date d2, Pageable pageable);
}
