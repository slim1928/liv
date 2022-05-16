package com.slim.livraison.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.LigneFactureEntity;
import com.slim.livraison.Répository.LfactureRépo;

@Service
public class LfactureServieImpli implements LigneFactService {
	
	@Autowired
	private LfactureRépo LfRépo;

	@Override
	public LigneFactureEntity save(LigneFactureEntity ligneFactureEntity) {
		
		return LfRépo.save(ligneFactureEntity);
	}

	@Override
	public List<LigneFactureEntity> getAll(Long id) {
		
		return LfRépo.findAll();
	}

	@Override
	public LigneFactureEntity update(LigneFactureEntity ligneFactureEntity, Long id) throws ResourceNotFoundException {
		Optional<LigneFactureEntity> optf= LfRépo.findById(id);
		if(optf.isPresent()) {
			ligneFactureEntity.setId(id);
			LigneFactureEntity updat= LfRépo.save(ligneFactureEntity);
			return updat;
		}else
			throw new ResourceNotFoundException("ligne facture not found");
		
	}

	@Override
	public void delete(Long id) {
		LfRépo.deleteById(id);
		
	}

	@Override
	public Optional<LigneFactureEntity> FindById(Long id) {
		
		return LfRépo.findById(id);
	}

	@Override
	public Page<LigneFactureEntity> getLignesFacture(Date d1, Date d2) {
		// TODO Auto-generated method stub
		return LfRépo.findAllBetween(d1,d2,new QPageRequest(0, 10));
	}

}
