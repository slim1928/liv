package com.slim.livraison.Répository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.slim.livraison.Model.ClientEntity;



@Repository
public interface ClientRépo extends JpaRepository<ClientEntity, Long> {
	
	ClientEntity findByNom(String nom);

	@Query("select c from ClientEntity  c where c.code = :x")
	public ClientEntity findByCode( @Param("x")String code ); 
	
	@Query("select p from ClientEntity  p where p.code like :x or p.nom like :x or p.username like :x or p.age like :x or p.address like :x or p.email like :x or p.tel like :x ")
	public Page<ClientEntity> findAllByMotCle( @Param("x")String mc, Pageable pageable );
}
