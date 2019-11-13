package com.fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.UserDao;
import com.fr.adaming.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	
	public void faireUnTruc() {
		// Ajouter deux Users
		
		//1)Préparer les instances d'objets java
		User user1 = new User("userNom1");
		user1.setEmail("admin@adaming.fr");
		user1.setPwd("azerty");
		user1.setActivated(false);
		user1.setRole("admin");
		
		User user2 = new User("userNom2");
		user2.setEmail("dev@adaming.fr");
		
		//2)Demander à la couche DAO (Repository) d'enregister les objets dans la BD
		dao.save(user1);
		dao.save(user2);
	}
	
	public User save(User entity) {
		return dao.save(entity);
	}
	
	public List<User> getAll(){
		return dao.findAll();
	}
	
	public User getById(int id) {
//		return dao.getOne(id);
		return dao.findById(id).get();		//TODO expliquer le Optional<User>
	}
	
	public void deleteObject(User user) {
		dao.delete(user);
	}
	
	public void updateObject(User user) {
		dao.save(user);
	}
	
	public User getByEmail(String email) {
		return dao.findByEmail(email);
	}
	
	public User login(String email, String pwd) {
		return dao.getByEmailAndPwd(email, pwd);
	}
	
	public void activateAdmins() {
		dao.activateUserIfItIsAnAdmin("admin");
	}
	
	public void deleteById(int id) {
		dao.deleteById(id);
	}
	
}
