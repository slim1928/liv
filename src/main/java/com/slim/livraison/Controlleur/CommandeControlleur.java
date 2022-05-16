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
import com.slim.livraison.Model.CommandeEntity;
import com.slim.livraison.Service.CommandeService;

@RestController
@RequestMapping("/commande")
public class CommandeControlleur {
 
	@Autowired
	private CommandeService cs;

	@PostMapping("")
	public CommandeEntity save(CommandeEntity commandeEntity) {
		return cs.save(commandeEntity);
	}

	@GetMapping("")
	public List<CommandeEntity> getAll(Long id) {
		return cs.getAll(id);
	}

	 @PutMapping("/id/{id}")
	public CommandeEntity update(@RequestBody() CommandeEntity commandeEntity, @PathVariable() Long id) throws ResourceNotFoundException {
		return cs.update(commandeEntity, id);
	}

	 @DeleteMapping("/id/{id}")
	public void delete(@PathVariable() Long id) {
		cs.delete(id);
	}

	 @GetMapping("/id/{id}")
	public CommandeEntity FindById(@PathVariable() Long id) {
		return cs.FindById(id);
	}
	
}
