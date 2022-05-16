package com.slim.livraison.Service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties.ClientType;
import org.springframework.data.domain.Page;

import com.slim.livraison.DTO.ClientRequestDto;
import com.slim.livraison.DTO.ClientResponseDto;
import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.ClientEntity;







public interface ClientService {

	ClientResponseDto save(ClientRequestDto clientRequestDto );
	
	ClientResponseDto  FindById(Long id);
	
	ClientResponseDto  findByNom(String nom);
	
	public Page<ClientEntity> getClients(int page, int size); 
	
	public Page<ClientEntity> getClientsByMotCle(String mc,int page, int size);
	
	ClientResponseDto update(ClientRequestDto clientRequestDto , Long id) throws ResourceNotFoundException ;
	
	void delete(Long id);
	
	List<ClientResponseDto> FinAll();

	public ClientEntity getClient(String code);

	public ClientEntity saveClient(@Valid ClientEntity client);
	
}
