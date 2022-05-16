package com.slim.livraison.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivraisonEntity {

	@Id @GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_CHAUFFEUR")
	private ChauffeurEntity chauffeur;
	 

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateLivraison; 
	
	private String adresse;
	
	@ManyToOne
	@JoinColumn(name="NUM_FACTURE")
	private FactureEntity facture;
	

}
