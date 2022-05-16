package com.slim.livraison.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.LivraisonEntity;
import com.slim.livraison.Répository.LivraisonRépo;

@Service
public class LivraisonServiceImpli implements LivraisonService{
	
	@Autowired
	private LivraisonRépo Livrepo;

	@Override
	public List<LivraisonEntity> getAllLivraisons() {
		
		return Livrepo.findAll()
				.stream()
				.collect(Collectors.toList());
	}

	@Override
	public Page<LivraisonEntity> getAllLivraisons(int page, int size) {
	
		return Livrepo.findAll(new QPageRequest(page, size));
	}

	@Override
	public LivraisonEntity getLivraison(Long id) {
		
		return Livrepo.getById(id);
	}

	@Override
	public LivraisonEntity saveLivraison(LivraisonEntity livraison) {
		
		return Livrepo.save(livraison);
	}

	@Override
	public LivraisonEntity updateLivrason(LivraisonEntity livraison, Long id)  throws ResourceNotFoundException {
		Optional<LivraisonEntity > optf=   Livrepo.findById(id);
		if(optf.isPresent()) {
			livraison.setId(id);
			LivraisonEntity  updat=  Livrepo.save(livraison);
			return updat;
		}else
			throw new ResourceNotFoundException("livraison not found");
		
	}

	@Override
	public boolean deleteLivraison(Long id) {
		LivraisonEntity lc = Livrepo.getById(id);
		if(lc==null) return false;
		Livrepo.delete(lc);
		return true;
	}

}
