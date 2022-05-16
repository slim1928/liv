package com.slim.livraison.Service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.ChauffeurEntity;
import com.slim.livraison.Model.ClientEntity;
import com.slim.livraison.Model.CommandeEntity;
import com.slim.livraison.Model.SocieteEntity;




public interface CommandeService {

	
    CommandeEntity save(CommandeEntity commandeEntity);
    
    public CommandeEntity saveCommande(Long id, Date date, boolean valide, ClientEntity clt,SocieteEntity soc);
	
	List<CommandeEntity> getAll(Long id);
	
	CommandeEntity update(CommandeEntity commandeEntity,Long id ) throws ResourceNotFoundException;
	
	public void delete(Long id);
	
	CommandeEntity FindById(Long id);
	
	public Page<CommandeEntity> findAllCommandesClients(Date date,int page, int size);
	public Page<CommandeEntity> findAllCommandesOfClient(Integer numero,Long id,Date date,int page, int size);
	public Page<CommandeEntity> findAllCommandesOfClient(Integer numero,Long id,Boolean valide,int page, int size);
	public Page<CommandeEntity> findAllCommandesOfClient(Integer numero,Long id,Boolean valide,Date date,int page, int size);
	public Integer countBetween(Date d1, Date d2);

	
	
	
	
	
}
