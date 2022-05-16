package com.slim.livraison.Service;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.ClientEntity;
import com.slim.livraison.Model.CommandeEntity;
import com.slim.livraison.Model.FactureEntity;
import com.slim.livraison.Model.SocieteEntity;


public interface FactureService {

	FactureEntity save(FactureEntity factureEntity);
	
	List<FactureEntity> getAll(Long id);
	
	FactureEntity update(FactureEntity factureEntity,Long id ) throws ResourceNotFoundException;
	
	public void delete(Long id);
	
	FactureEntity FindById(Long id);
	
	public FactureEntity saveFacture(Long id, CommandeEntity commande, ClientEntity clt, SocieteEntity soc);
	
	public Page<FactureEntity> findAllFacturesClients(Long numero,Date date,int page, int size);
	public Page<FactureEntity> findAllFacturesOfClient(Long numero,Long id,int page, int size);
	public Page<FactureEntity> findAllFacturesOfClient(Long numero,Long id,Date date,int page, int size);
	
	
}
