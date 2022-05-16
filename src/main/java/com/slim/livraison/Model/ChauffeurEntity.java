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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "chauffeur")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChauffeurEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    @Size(max = 40)
	    private String nom;

	    @NotBlank
	    @Size(max = 15)
	    private String username;

	  
	    @NotBlank
	    @Size(max = 40)
	    @Email
	    private String email;
	    
	    @Size(min=8, max=100,message="Le numéro de télephone doit etre composé de 10 nombres !")
		private String tel; 
	
	private TypeVéhicule typevéhicule;
	
	private StatusChauff status;
	
	@NotBlank
    @Size(max = 40)
	private String positionActuel;
	
	@NotBlank
    @Size(max = 40)
	private String destinationCommande;
	

	@OneToMany(mappedBy = "chauffeur" , cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Collection<LivraisonEntity> livraisons;
	
	
	
	
	
	
	
}
