package com.slim.livraison.Service;

import java.util.List;

import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.LigneCommandeEntity;


public interface LcommandeService {

	public List<LigneCommandeEntity> FindAll();
	public LigneCommandeEntity getLigneCommande( Long id ); 
	public LigneCommandeEntity getLigneCommandeByProduit( Long id, String ref ); 
	public LigneCommandeEntity saveLigneCommande(LigneCommandeEntity ligneCommande);
	public boolean deleteLigneCommande(Long id);
	public LigneCommandeEntity findLcByProduit(Long numCommande,String ref);
	public LigneCommandeEntity update(LigneCommandeEntity ligneCommande,Long id ) throws ResourceNotFoundException;
}
