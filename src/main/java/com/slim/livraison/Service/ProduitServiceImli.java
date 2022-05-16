package com.slim.livraison.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.ProduitEntity;
import com.slim.livraison.Répository.ProduitRépo;


@Service
public class ProduitServiceImli implements ProduitService {
	
	@Autowired
	private ProduitRépo Prepo;
	
	
	
	@Override
	public ProduitEntity findByRef(String ref) {
		
		return Prepo.findByRef(ref);
	}

	@Override
	public ProduitEntity save(ProduitEntity produitEntity) {
		
		return Prepo.save(produitEntity);
	}

	@Override
	public void delete(Long Id) {
		
		 Prepo.deleteById(Id);
	}

	@Override
	public ProduitEntity findById(Long Id) {
		
		return Prepo.findById(Id).orElseThrow(() -> new RuntimeException("produit not found"));
	}

	@Override
	public List<ProduitEntity> FindAll() {
		
		return  Prepo.findAll()
				.stream()
				.collect(Collectors.toList());
	}

	@Override
	public ProduitEntity updateProduit(ProduitEntity produitEntity, Long Id) throws ResourceNotFoundException {
		Optional<ProduitEntity> p =Prepo.findById(Id);
		if (p.isPresent()) {
			produitEntity.setId(Id);
		    ProduitEntity update=Prepo.save(produitEntity);
		    return update;
		}else {
			throw new ResourceNotFoundException("Produit not found"); 
		}


	}

	@Override
	public Page<ProduitEntity> findAllByMotCle(String mc, int page, int size) {
		
		return Prepo.findAllByMotCle(mc,new QPageRequest(page, size));
	}

	
}
