package com.slim.livraison.Répository;

import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.slim.livraison.Model.CommandeEntity;

@Repository
public interface CommandeRépo extends JpaRepository<CommandeEntity, Long> {

	@Query("select p from CommandeEntity p where p.dateCommande=:x ")
	
	public Page<CommandeEntity> findAllCommandesClients(@Param("x")Date date,Pageable pageable);
	
	@Query("select p from CommandeEntity p where p.client.id=:c and p.dateCommande=:d and p.numero=:num")
	public Page<CommandeEntity> findAllCommandesOfClient(@Param("num")Integer numero,@Param("c")Long id,@Param("d")Date date, Pageable pageable);

	@Query("select p from CommandeEntity p where p.client.id = :c and p.valide = :v  and p.numero=:num")
	public Page<CommandeEntity> findAllCommandesOfClient(@Param("num")Integer numero,@Param("c")Long id,@Param("v")Boolean valide,Pageable pageable);
 
	@Query("select p from CommandeEntity p where p.client.code = :c and p.valide = :v and p.dateCommande=:d  and p.numero=:num")
	public Page<CommandeEntity> findAllCommandesOfClient(@Param("num")Integer numero,@Param("c")Long id,@Param("v")Boolean valide,@Param("d")Date date,Pageable pageable);
	
	@Query("select count(p) from CommandeEntity p where p.dateCommande between :d1 and :d2")
	public Integer countBetween(@Param("d1")Date d1, @Param("d2")Date d2);

}
