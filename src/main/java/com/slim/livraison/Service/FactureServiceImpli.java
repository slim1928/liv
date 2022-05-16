package com.slim.livraison.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.ClientEntity;
import com.slim.livraison.Model.CommandeEntity;
import com.slim.livraison.Model.FactureEntity;
import com.slim.livraison.Model.SocieteEntity;
import com.slim.livraison.Répository.FactureRépo;

@Service
public class FactureServiceImpli implements FactureService {

	@Autowired
	private FactureRépo Frepo;
	
	@Override
	public FactureEntity save(FactureEntity factureEntity) {
		
		return Frepo.save(factureEntity);
	}

	@Override
	public List<FactureEntity> getAll(Long id) {
		
		return Frepo.findAll().stream()
				.collect(Collectors.toList());
	}

	@Override
	public FactureEntity update(FactureEntity factureEntity, Long id) throws ResourceNotFoundException {
		Optional<FactureEntity> f =Frepo.findById(id);
		if (f.isPresent()) {
			factureEntity.setId(id);
			FactureEntity updat=Frepo.save(factureEntity);
		    return updat;
		}else {
			throw new ResourceNotFoundException("FACTURE not found"); 
		}


	}

	@Override
	public void delete(Long id) {
		Frepo.deleteById(id);
		
	}

	@Override
	public FactureEntity FindById(Long id) {
		
		return Frepo.findById(id).orElseThrow(() -> new RuntimeException("facture not found"));
	}

	@Override
	public Page<FactureEntity> findAllFacturesClients(Long numero, Date date, int page, int size) {
		
		return Frepo.findAllFacturesClients(numero, date, new QPageRequest(page, size));
	}

	@Override
	public Page<FactureEntity> findAllFacturesOfClient(Long numero, Long id, int page, int size) {
		
		return Frepo.findAllFacturesOfClient(numero, id,  new QPageRequest(page, size));
	}

	@Override
	public Page<FactureEntity> findAllFacturesOfClient(Long numero, Long id, Date date, int page, int size) {
		// TODO Auto-generated method stub
		return Frepo.findAllFacturesOfClient(numero, id, date, new QPageRequest(page, size));
	}

	@Override
	public FactureEntity saveFacture(Long id, CommandeEntity commande, ClientEntity clt, SocieteEntity soc) {
		FactureEntity com= new FactureEntity();
		com.setId(id);
		com.setClients(clt);
		com.setCommande(commande);
		com.setSociete(soc);
		return Frepo.save(com);
		
	}

}
