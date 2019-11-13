package com.fr.adaming.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fr.adaming.controller.dto.LoginDto;
import com.fr.adaming.dto.RegisterDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @NoArgsConstructor @ToString @RequiredArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	private String nom;

	@Column(unique = true)
	private String email;
	
	private String pwd;
	
	private boolean activated;
	
	private String role; // User ou Admin	
	
	private LocalDate birthDate;
	
	//Exemple de constructeur pour convertir un DTO en une Entity
	public User(RegisterDto dto) {
		this.nom = dto.getNom();
		this.email = dto.getEmail();
		this.pwd = dto.getPwd();
		this.birthDate = dto.getBirthDate();
	}

	//Exemple de constructeur pour convertir un DTO en une Entity
	public User(LoginDto dto) {
		this.email = dto.getEmail();
		this.pwd = dto.getPwd();
	}
	
	
}
