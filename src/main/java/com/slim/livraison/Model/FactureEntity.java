package com.slim.livraison.Model;


import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FactureEntity {

	@Id @GeneratedValue
	private Long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFacture;
	 
	private Long numero;
	
	private double total;
	
	@ManyToOne
	private ClientEntity clients;
	
	@ManyToOne
	private CommandeEntity commande;
	
	@ManyToOne
	private SocieteEntity societe;
	
	@OneToMany(mappedBy= "facture", cascade = CascadeType.REMOVE)
	private Collection<LigneFactureEntity> lignesFacture;
	
	@OneToMany(mappedBy = "facture",cascade = CascadeType.REMOVE)
	private List<LivraisonEntity> livraison;

	
		
	
	
	
	
	
	
	
	
}