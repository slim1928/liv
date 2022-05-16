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

import com.slim.livraison.DTO.ChauffuerRequestDto;
import com.slim.livraison.DTO.ChauffuerResponseDto;
import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Service.ChauffeurService;

@RestController
@RequestMapping("/chauffeur")
public class ChauffeurControlleur {

	@Autowired
	private ChauffeurService chauffeurservive;
	
	
	@GetMapping("")
	public List<ChauffuerResponseDto> getChauffeur(){
		
	 	return chauffeurservive.FinAll();
	}
	
	@GetMapping("/id/{id}")
	public ChauffuerResponseDto finById(@PathVariable()  Long id) {
		return chauffeurservive.findById(id);
	}
	
	@GetMapping("/{nom}")
	ChauffuerResponseDto  findByNom(@PathVariable()  String nom) {
		return chauffeurservive.findByNom(nom);
	}
	
	@PostMapping("")
	ChauffuerResponseDto save(@RequestBody()  ChauffuerRequestDto chauffuerRequestDto) {
		
		return chauffeurservive.save(chauffuerRequestDto);
	}
	
	@PutMapping("/id/{id}")
	ChauffuerResponseDto update(@RequestBody() ChauffuerRequestDto chauffuerRequestDto,@PathVariable() Long id) throws ResourceNotFoundException{
		return chauffeurservive.update(chauffuerRequestDto, id);
	}
	
	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable Long id) {
		chauffeurservive.delete(id);
	}
	
	
	
}
