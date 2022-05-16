package com.slim.livraison.Model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="societé")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class SocieteEntity   {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdSociéte;
	
	@Column(length=50)
	private String nom;
	
	@Email @NotBlank 
	private String email;
	
	@Size(min=8, max=100,message="Le numéro de télephone doit etre composé de 10 nombres !")
	private String telephone;
	
	@Size(min=4, max=100) 
	private String address;
	
	@OneToMany(mappedBy = "societe", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Collection<FactureEntity> factures;
	
	@OneToMany(mappedBy = "societe" , cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Collection<CommandeEntity> commande;
}
