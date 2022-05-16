package com.slim.livraison.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.LivraisonEntity;



public interface LivraisonService {

	public List<LivraisonEntity> getAllLivraisons();
	public Page<LivraisonEntity> getAllLivraisons(int page, int size ); 
	public LivraisonEntity getLivraison( Long id );   
	public LivraisonEntity saveLivraison(LivraisonEntity livraison);
	public LivraisonEntity updateLivrason(LivraisonEntity livraison, Long id) throws ResourceNotFoundException;
	public boolean deleteLivraison(Long id);
}
