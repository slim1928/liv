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
import com.slim.livraison.Model.SocieteEntity;
import com.slim.livraison.Répository.CommandeRépo;

@Service
public class CommandeServiceImpli implements CommandeService{
	
	@Autowired
	private CommandeRépo Crepo;

	@Override
	public CommandeEntity save(CommandeEntity commandeEntity) {
		
		return Crepo.save(commandeEntity);
	}

	@Override
	public List<CommandeEntity> getAll(Long id) {
		
		return  Crepo.findAll().stream()
				.collect(Collectors.toList());
	}

	@Override
	public CommandeEntity update(CommandeEntity commandeEntity, Long id) throws ResourceNotFoundException {
		Optional<CommandeEntity> opt= Crepo.findById(id);
		if (opt.isPresent()) {
			commandeEntity.setId(id);
			CommandeEntity updat =Crepo.save(commandeEntity);
			return updat;
		}else {
			throw new ResourceNotFoundException("commande not found");
		}
		
	}

	@Override
	public void delete(Long id) {
		Crepo.deleteById(id);
		
	}

	@Override
	public CommandeEntity FindById(Long id) {
		
		return Crepo.findById(id).orElseThrow(() -> new RuntimeException("facture not found"));
	}

	@Override
	public CommandeEntity saveCommande(Long id, Date date, boolean valide, ClientEntity clt, SocieteEntity soc) {
		CommandeEntity com= new CommandeEntity();
		com.setId(id);
		com.setClient(clt);
		com.setDateCommande(date);
		com.setValide(valide);
		com.setSociete(soc);
		return Crepo.save(com);
	}

	@Override
	public Page<CommandeEntity> findAllCommandesClients(Date date, int page, int size) {
		
		return Crepo.findAllCommandesClients(date ,new QPageRequest(page, size));
	}

	@Override
	public Page<CommandeEntity> findAllCommandesOfClient(Integer numero, Long id, Date date, int page, int size) {
		
		return  Crepo.findAllCommandesOfClient(numero, id, date ,new QPageRequest(page, size));
	}

	@Override
	public Page<CommandeEntity> findAllCommandesOfClient(Integer numero, Long id, Boolean valide, int page, int size) {
		
		return Crepo.findAllCommandesOfClient(numero, id, valide, new QPageRequest(page, size));
	}

	@Override
	public Page<CommandeEntity> findAllCommandesOfClient(Integer numero, Long id, Boolean valide, Date date, int page,
			int size) {
		
		return Crepo.findAllCommandesOfClient(numero, id, valide, date, new QPageRequest(page, size));
	}

	@Override
	public Integer countBetween(Date d1, Date d2) {
		
		return Crepo.countBetween(d1, d2);
	}

}
