package com.slim.livraison.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LigneFactureEntity {

	@Id @GeneratedValue
	private Long id;
	
	private int qte;
	private double prix; 
	
	private double total;
	
	private double ttc;
	
	@ManyToOne
	private FactureEntity facture;
	
	@ManyToOne
	private ProduitEntity produit;
	
	
}
