package com.fr.adaming.service.test;

import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fr.adaming.entity.User;
import com.fr.adaming.service.UserService;

@Component
public class UserServiceTest {

	@Autowired
	private UserService service;
	
	@PostConstruct
	public void initScenario() {
		this.loginTest();
		this.getByIdTest();
	}
	
	public void loginTest() {
		
		//Préparer les inputs
		
		String email = "admin@adaming.fr";
		String pwd = "azerty";
		
		//invoquer la méthode
		User user = service.login(email, pwd);
		
		//vérifier le retour (ou les exception)
		if(user != null) {
			System.out.println("login() : SUCCESS");
		}else {
			System.out.println("login() : FAIL");
		}
	}
	
	
	public void getByIdTest() {
		//Préparer mes inputs
		int id = 55;	//On suppose qu'on a insérer un User dans la BD avec l'id 55
		
		//invoquer la méthod
		try {
		User user = service.getById(id);
		
		
		//vérifier le retour (ou les exception)
		if(user != null) {
			System.out.println("getById() : SUCCESS");
		}
		
		}catch(NoSuchElementException e) {
			System.out.println("getById() : FAIL");
		}
	}
	
}
