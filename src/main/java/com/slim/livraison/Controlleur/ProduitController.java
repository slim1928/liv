package com.slim.livraison.Controlleur;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.ProduitEntity;
import com.slim.livraison.Service.ProduitService;

@RestController
@RequestMapping("/produits")
public class ProduitController {

	@Autowired
	private ProduitService produitservice;
	
	
	@GetMapping("")
	List<ProduitEntity> FindAll(){
		return produitservice.FindAll();
	}
	
	@GetMapping("/id/{Id}")
	ProduitEntity findById(@PathVariable() Long Id){
		return produitservice.findById(Id);
	}
	
	@PostMapping("")
	 public ProduitEntity save( @RequestBody() ProduitEntity produitEntity) {
		 return produitservice.save(produitEntity);
	 }
	
	@DeleteMapping("/id/{Id}")
	public void delete(@PathVariable() Long Id) {
		produitservice.delete(Id);
	}
	
	@PutMapping("/id/{Id}")
	public ProduitEntity updateProduit(@RequestBody() ProduitEntity produitEntity, @PathVariable() Long Id) throws ResourceNotFoundException {
		return produitservice.updateProduit(produitEntity,Id);
	}
	
}
