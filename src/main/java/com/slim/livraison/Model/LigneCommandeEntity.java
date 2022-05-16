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
public class LigneCommandeEntity {

	@Id @GeneratedValue
	private Long id;
	
	private int qte;
	
	private double total;
	
	private int numero;
	
	
	@ManyToOne
	private CommandeEntity commande;
	
	@ManyToOne
	private ProduitEntity produit;
}
