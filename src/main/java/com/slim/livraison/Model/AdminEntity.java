package com.slim.livraison.Model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    @Size(max = 40)
	    private String name;

	    @NotBlank
	    @Size(max = 15)
	    private String username;

	    @NaturalId
	    @NotBlank
	    @Size(max = 40)
	    @Email
	    private String email;
	    
	    @Size(min=8, max=100,message="Le numéro de télephone doit etre composé de 10 nombres !")
		private String tel; 

	    @NotBlank
	    @Size(max = 100)
	    private String password;
	    
	    @OneToMany(mappedBy= "admin", cascade = CascadeType.REMOVE)
	    private Collection<Abonnement> abonnement;
}
