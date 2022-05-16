package com.slim.livraison.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.SocieteEntity;
import com.slim.livraison.Répository.SocieteRépo;


@Service
public class SocieteServiceImpli implements SocieteService {
	
	@Autowired
	private SocieteRépo socrepo;
	

	@Override
	public SocieteEntity save(SocieteEntity societeEntity) {
		
		return socrepo.save(societeEntity);
	}

	@Override
	public void delete(Long IdSociéte) {
		 socrepo.deleteById(IdSociéte);
	}


	@Override
	public SocieteEntity findByNom(String nomsociete) {
		
		return socrepo.findByNom(nomsociete);
	}

	@Override
	public SocieteEntity findById(Long IdSociéte) {
		
		return socrepo.findById(IdSociéte).orElseThrow(() -> new RuntimeException("societe not found"));
	}

	@Override
	public List<SocieteEntity> FindAll() {
		
		return socrepo.findAll()
				.stream()
				.collect(Collectors.toList());
	}

	@Override
	public SocieteEntity update(SocieteEntity societeEntity, Long IdSociéte) throws ResourceNotFoundException {
		Optional<SocieteEntity> sop= socrepo.findById(IdSociéte);
		if (sop.isPresent()) {
			societeEntity.setIdSociéte(IdSociéte);
			SocieteEntity updat=socrepo.save(societeEntity);
			return updat;
		}else {
			throw new ResourceNotFoundException("Societe not found");
		}
		
	}

	
}

	

	


