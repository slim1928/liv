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
import com.slim.livraison.Model.SocieteEntity;
import com.slim.livraison.Service.SocieteService;



@RestController
@RequestMapping("/societe")
public class SocieteController {

	
	@Autowired
	private SocieteService societeservive;
	
	@GetMapping("")
	public List<SocieteEntity> FindAll() {
		return societeservive.FindAll();
	}
	
	
	@GetMapping("/id/{IdSociéte}")
	public SocieteEntity finById(@PathVariable()  Long IdSociéte) {
		return societeservive.findById(IdSociéte);
	}
	
	@PostMapping("")
	public SocieteEntity save(@RequestBody() SocieteEntity societeEntity) {
		return societeservive.save(societeEntity);
	}
	
	@DeleteMapping("/id/{IdSociéte}")
	public void delete(@PathVariable() Long IdSociéte) {
		societeservive.delete(IdSociéte);
	}
	
	@PutMapping("/id/{IdSociéte}")
	public SocieteEntity update(@RequestBody() SocieteEntity societeEntity,@PathVariable() Long IdSociéte) throws ResourceNotFoundException {
		return societeservive.update(societeEntity, IdSociéte);
	}
	
}
