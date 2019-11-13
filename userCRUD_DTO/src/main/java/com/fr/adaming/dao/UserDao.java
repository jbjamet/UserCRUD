package com.fr.adaming.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	
	public User findByEmail(String xxx);
	
	public User getByEmailAndPwd(String email, String pwd);
	
	public List<User> findByEmailIn(List<String> email);
	
	//update user set activated = true where role like 'admin'
	@Transactional
	@Modifying
	@Query(value = "update user set activated = true where role like :xRole", nativeQuery = true)
	public void activateUserIfItIsAnAdmin(@Param(value = "xRole") String mqlskdjfmqsldj);
	
	//findBbyEmailIn("admin@adaming.fr", "a@adaming.fr", "b@adaming.fr")
	
	//SELECT * from User where email in('admin@adaming.fr')
	
}
