package com.slim.livraison.Controlleur;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.slim.livraison.DTO.ClientRequestDto;
import com.slim.livraison.DTO.ClientResponseDto;
import com.slim.livraison.Exception.ResourceNotFoundException;
import com.slim.livraison.Model.ClientEntity;
import com.slim.livraison.Service.ClientService;







@RestController
@RequestMapping("/clients")
public class ClientControlleur {

	 @Autowired
	    private ClientService clientService;
	 
	 public String index
		( 
			Model model,
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="8")int s,
			@RequestParam(name="mc",defaultValue="")String mc
		) 
	{
		Page<ClientEntity> clientes = clientService.getClientsByMotCle("%"+mc+"%", p, s);
		model.addAttribute("clients", clientes.getContent());
		model.addAttribute("pages", new int[clientes.getTotalPages()]);
		model.addAttribute("size", s);
		model.addAttribute("pageCourant", p);
		model.addAttribute("mc", mc); 
		
		if(!model.containsAttribute("client"))
		model.addAttribute("client", new ClientEntity()); 
		
		return "clientes"; 
	}
	
		
	    
	

	@GetMapping("")
	    public List<ClientResponseDto> getClient(){
	    
	    	return clientService.FinAll();
	    	
	    }
	
	 @PostMapping("")	
	    public ClientResponseDto  save( @RequestBody() ClientRequestDto clientRequestDto) {
	    	
	    return clientService.save(clientRequestDto) ;
	    }
	 
	 @GetMapping("/id/{id}")
		public ClientResponseDto FindById(@PathVariable()  Long id) {
			return clientService.FindById(id);
		}
	 
	 @GetMapping("/{nom}")
		public ClientResponseDto findByNom(@PathVariable()  String nom) {
			return clientService.findByNom(nom);
		}
	 
	 @DeleteMapping("/id/{id}")
		public void delete(@PathVariable() Long id) {
			clientService.delete(id);
	 }

	 @PutMapping("/id/{id}")
		public ClientResponseDto update(   @ RequestBody() ClientRequestDto clientRequestDto,@PathVariable() Long id) throws ResourceNotFoundException {
			return clientService.update(clientRequestDto, id);
		}
	 
}
