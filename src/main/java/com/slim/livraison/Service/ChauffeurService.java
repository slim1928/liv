package com.slim.livraison.Service;

import java.util.List;

import com.slim.livraison.DTO.ChauffuerRequestDto;
import com.slim.livraison.DTO.ChauffuerResponseDto;


import com.slim.livraison.Exception.ResourceNotFoundException;


public interface ChauffeurService {

	
	ChauffuerResponseDto save(ChauffuerRequestDto chauffuerRequestDto);
	
	ChauffuerResponseDto findById(Long id);
	
	ChauffuerResponseDto findByNom(String nom);
	
	void delete(Long id);
	
	ChauffuerResponseDto update(ChauffuerRequestDto chauffuerRequestDto,Long id) throws ResourceNotFoundException;
	
	List<ChauffuerResponseDto> FinAll();
	
}
