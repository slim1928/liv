package com.slim.livraison.Model;



import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Client")
public class ClientEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotNull @Size(min=3, max=100)
		private String code;

	    @NotBlank
	    @Size(max = 40)
	    private String nom;

	    @NotBlank
	    @Size(max = 15)
	    private String username;

	    @Min(18)
	    private int age;
	    
	    @Size(min=4, max=100) 
	    private String address;
	    
	  
	    @NotBlank
	    @Size(max = 40)
	    @Email
	    private String email;
	    
	    @Size(min=8, max=100,message="Le numéro de télephone doit etre composé de 10 nombres !")
		private String tel; 
	    
	
	@OneToMany(mappedBy = "clients" , cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Collection<FactureEntity> Cfacture;
	
	@OneToMany(mappedBy = "client" , cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Collection<CommandeEntity> commande; 
	
}
