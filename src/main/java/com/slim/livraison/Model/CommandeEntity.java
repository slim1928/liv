package com.slim.livraison.Model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "commande")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommandeEntity {

	@Id @GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private int numero;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date dateCommande;
	
	@NotNull
	private boolean valide;
	
	@OneToMany(mappedBy = "commande", cascade = CascadeType.REMOVE)
	private Collection<FactureEntity> factures;
	
	@ManyToOne
	private ClientEntity client;
	
	@ManyToMany(mappedBy = "commandes", cascade = CascadeType.REMOVE)
	private List<Affectation> affectation;
	

	@ManyToOne
	private SocieteEntity societe;
	
	@OneToMany(mappedBy="commande",fetch=FetchType.LAZY)
	private Collection<LigneCommandeEntity> lignesCommande;


	
	
}
