package com.slim.livraison.Répository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slim.livraison.Model.LivraisonEntity;

@Repository
public interface LivraisonRépo extends JpaRepository<LivraisonEntity, Long> {

}
