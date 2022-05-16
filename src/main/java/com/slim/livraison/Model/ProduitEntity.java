package com.slim.livraison.Model;


import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProduitEntity {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
    @NotNull @Size(min=2, max=1000) 
	private String ref; 
	
	@Size(min=2, max=1000) 
	private String designation; 
	
	@NotBlank 
	private Float poids;
	
	@Min(0)
	private int quantite;
	
	@OneToMany(mappedBy = "produit" , cascade = CascadeType.REMOVE)
	private Collection<LigneCommandeEntity> lignecommande;
	
	
}
