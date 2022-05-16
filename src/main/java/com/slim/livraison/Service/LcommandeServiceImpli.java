package com.slim.livraison.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.LigneCommandeEntity;
import com.slim.livraison.Répository.LcommandeRépo;



public class LcommandeServiceImpli implements LcommandeService {

	@Autowired
	private LcommandeRépo lrepo;
	
	@Override
	public LigneCommandeEntity getLigneCommande(Long id) {
		
		return  lrepo.getById(id);
	}

	@Override
	public LigneCommandeEntity getLigneCommandeByProduit(Long id, String ref) {
		
		return  lrepo.findLcByProduit(id, ref);
	}

	@Override
	public LigneCommandeEntity saveLigneCommande(LigneCommandeEntity ligneCommande) {
		
		return  lrepo.save(ligneCommande);
	}

	@Override
	public boolean deleteLigneCommande(Long id) {
		LigneCommandeEntity lc = lrepo.getById(id);
		if(lc==null) return false;
		lrepo.delete(lc);
		return true;
		
	}

	@Override
	public List<LigneCommandeEntity> FindAll() {
		
		return lrepo.findAll().stream()
				.collect(Collectors.toList());
	}

	@Override
	public LigneCommandeEntity update(LigneCommandeEntity ligneCommande, Long id) throws ResourceNotFoundException {
		Optional<LigneCommandeEntity> optf=  lrepo.findById(id);
		if(optf.isPresent()) {
			ligneCommande.setId(id);
			LigneCommandeEntity updat=  lrepo.save(ligneCommande);
			return updat;
		}else
			throw new ResourceNotFoundException("ligne commande not found");
		
	}

	@Override
	public LigneCommandeEntity findLcByProduit(Long numCommande, String ref) {
	
		return lrepo.findLcByProduit(numCommande, ref);
	}

}
