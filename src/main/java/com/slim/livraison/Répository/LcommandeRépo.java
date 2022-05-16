package com.slim.livraison.Répository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.slim.livraison.Model.LigneCommandeEntity;


@Repository
public interface LcommandeRépo extends JpaRepository<LigneCommandeEntity, Long> {
	
	@Query("select p from LigneCommandeEntity p where p.produit.ref=:x and p.commande.numero=:num")
	public LigneCommandeEntity findLcByProduit( @Param("num")Long numCommande, @Param("x")String ref );
}
