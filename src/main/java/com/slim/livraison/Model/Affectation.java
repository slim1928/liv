package com.slim.livraison.Model;

import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Affectation {

	@Id @GeneratedValue(strategy =GenerationType.AUTO)
	private Long idAffect;
	
	private Date début_affectation;
	
	private Date fin_affectation;
	
	@ManyToMany
	@JoinTable(name = "affectation_id")
	@JsonIgnore
	private List<CommandeEntity> commandes;
	
}
