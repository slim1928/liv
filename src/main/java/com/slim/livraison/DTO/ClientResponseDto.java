package com.slim.livraison.DTO;



import lombok.Data;

@Data
public class ClientResponseDto {

    private Long id;
    private String code;
	private String nom;
	private String username;
	private int age;
	private String tel;
	private String email; 
	private String address;
}
