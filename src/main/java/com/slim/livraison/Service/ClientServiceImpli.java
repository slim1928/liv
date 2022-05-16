package com.slim.livraison.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import com.slim.livraison.DTO.ClientRequestDto;
import com.slim.livraison.DTO.ClientResponseDto;
import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.ClientEntity;
import com.slim.livraison.Répository.ClientRépo;



@Service
public class ClientServiceImpli implements ClientService{
	
	private ClientRépo clientrepo;
	private ModelMapper model;
	
	
    @Autowired
	public ClientServiceImpli(ClientRépo clientrepo,ModelMapper model) {
		super();
		this.clientrepo=clientrepo;
		this.model=model;
	}

	@Override
	public ClientResponseDto save(ClientRequestDto clientRequestDto) {
		ClientEntity cliententity= model.map(clientRequestDto, ClientEntity.class);
		ClientEntity saved= clientrepo.save(cliententity);
		return model.map(saved , ClientResponseDto.class);
	}

	@Override
	public ClientResponseDto FindById(Long id) {
		ClientEntity cliententity= clientrepo.findById(id).orElseThrow(() -> new RuntimeException("client not found"));
		return model.map(cliententity , ClientResponseDto.class);
	}

	@Override
	public ClientResponseDto findByNom(String nom) {
		ClientEntity cliententity= clientrepo.findByNom(nom);
		return model.map(cliententity , ClientResponseDto.class);
	}

	@Override
	public ClientResponseDto update(ClientRequestDto clientRequestDto, Long id) throws ResourceNotFoundException {
		Optional<ClientEntity> clientopt= clientrepo.findById(id);
		if (clientopt.isPresent()) {
			ClientEntity cliententity = model.map(clientRequestDto, ClientEntity.class);
   	        cliententity.setId(id);
   	        ClientEntity update = clientrepo.save(cliententity);
			return model.map(update , ClientResponseDto.class);
		}else {
			throw new ResourceNotFoundException ("client not found");
		}
			
		
	}

	@Override
	public void delete(Long id) {
		clientrepo.deleteById(id);
		
	}

	@Override
public List<ClientResponseDto> FinAll() {
		
		
		return clientrepo.findAll()
				.stream()
				.map(el -> model.map(el, ClientResponseDto.class))
				.collect(Collectors.toList());
	}

	
	@Override
	public Page<ClientEntity> getClients(int page, int size) {
		
		return clientrepo.findAll(new QPageRequest(page, size));
	}

	@Override
	public Page<ClientEntity> getClientsByMotCle(String mc, int page, int size) {
		
		return clientrepo.findAllByMotCle(mc,new QPageRequest(page, size));
				}

	@Override
	public ClientEntity getClient(String code) {
		try { 
			return clientrepo.findByCode(code);
		} catch (Exception e) {return null;} 
	}

	@Override
	public ClientEntity saveClient(@Valid ClientEntity client) {
		
		return clientrepo.save(client);
	}
	

	
}
