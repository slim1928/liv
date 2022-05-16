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
import com.slim.livraison.Model.ClientEntity;
import com.slim.livraison.Model.CommandeEntity;
import com.slim.livraison.Model.FactureEntity;
import com.slim.livraison.Model.SocieteEntity;
import com.slim.livraison.Service.FactureService;


@RestController
@RequestMapping("/facture")
public class FactureControlleur {

	
	@Autowired
	private FactureService factureService;
	
	
	@PostMapping("")
	public FactureEntity save(@RequestBody() FactureEntity factureEntity) {
		return factureService.save(factureEntity);
	}
	
	@GetMapping()
	public List<FactureEntity> getAll(Long id) {
		return factureService.getAll(id);
	}
	
	@PutMapping("/id/{id}")
	public FactureEntity update(@RequestBody() FactureEntity factureEntity,@PathVariable() Long id) throws ResourceNotFoundException {
		return factureService.update(factureEntity, id);
	}
	
	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable() Long id) {
		factureService.delete(id);
	}
	@GetMapping("/id/{id}")
	public FactureEntity FindById(@PathVariable() Long id) {
		return factureService.FindById(id);
	}

	@PostMapping("/id/{id}")
	public FactureEntity saveFacture(@PathVariable() Long id, @RequestBody() CommandeEntity commande, @RequestBody() ClientEntity clt, @RequestBody() SocieteEntity soc) {
		
		return factureService.saveFacture(id, commande, clt, soc);
	}
	
	
	
	
}
