package com.slim.livraison.DTO;



import com.slim.livraison.Model.StatusChauff;
import com.slim.livraison.Model.TypeVéhicule;

import lombok.Data;

@Data
public class ChauffuerResponseDto {

    private Long id;
    private String nom;
	private String username;
	private String tel;
	private String email;
	private TypeVéhicule typevéhicule;
	private StatusChauff status;
	private String positionActuel;
	private String destinationCommande;
}
