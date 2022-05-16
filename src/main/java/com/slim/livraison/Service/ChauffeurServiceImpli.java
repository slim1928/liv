package com.slim.livraison.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slim.livraison.DTO.ChauffuerRequestDto;
import com.slim.livraison.DTO.ChauffuerResponseDto;


import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.ChauffeurEntity;
import com.slim.livraison.Répository.ChauffeurRépo;

@Service
public class ChauffeurServiceImpli implements ChauffeurService {
	
	private ChauffeurRépo chauffeurrepo;
	private ModelMapper model;


	@Autowired
	public ChauffeurServiceImpli(ChauffeurRépo chauffeurrepo,ModelMapper model) {
		super();
		this.chauffeurrepo=chauffeurrepo;
		this.model=model;
		}

	@Override
	public ChauffuerResponseDto save(ChauffuerRequestDto chauffuerRequestDto) {
		ChauffeurEntity chauffeurentity=model.map(chauffuerRequestDto, ChauffeurEntity.class);
		ChauffeurEntity saved =chauffeurrepo.save(chauffeurentity);
		
		return model.map(saved, ChauffuerResponseDto.class);
	}

	@Override
	public ChauffuerResponseDto findById(Long id) {
		ChauffeurEntity chauffeurentity=chauffeurrepo.findById(id).orElseThrow(() -> new RuntimeException("chauffeur not found"));
		return model.map(chauffeurentity , ChauffuerResponseDto .class);
	}

	@Override
	public ChauffuerResponseDto findByNom(String nom) {
		ChauffeurEntity chauffeurentity=chauffeurrepo.findByNom(nom);
		return model.map(chauffeurentity, ChauffuerResponseDto.class);
	}

	@Override
	public void delete(Long id) {
		chauffeurrepo.deleteById(id);
		
	}

	@Override
	public ChauffuerResponseDto update(ChauffuerRequestDto chauffuerRequestDto, Long id) throws ResourceNotFoundException   {
		Optional<ChauffeurEntity> chauffeuropt= chauffeurrepo.findById(id);
		if (chauffeuropt.isPresent()) {
			ChauffeurEntity chauffeurentity=model.map(chauffuerRequestDto, ChauffeurEntity.class);
			chauffeurentity.setId(id);
			ChauffeurEntity update=chauffeurrepo.save(chauffeurentity);
			return model.map(update, ChauffuerResponseDto.class);
		}else {
		
			throw new ResourceNotFoundException("chauffeur not found");
		      }
	}

	@Override
	public List<ChauffuerResponseDto> FinAll() {
		
		return chauffeurrepo.findAll()
				.stream()
				.map(el -> model.map(el, ChauffuerResponseDto.class))
				.collect(Collectors.toList());
		
					
	}

}
