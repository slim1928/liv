package com.slim.livraison.Model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Abonnement {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long idAbonn;
	
	private double prix;
	
	private LocalDate DateDeDébut;
	
	private Date DateDeFin;
	
	@ManyToOne
	private AdminEntity admin;
	
}
