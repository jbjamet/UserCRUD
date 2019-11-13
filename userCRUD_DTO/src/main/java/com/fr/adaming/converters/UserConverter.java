package com.fr.adaming.converters;

import java.util.ArrayList;
import java.util.List;

import com.fr.adaming.dto.RegisterDto;
import com.fr.adaming.entity.User;

public class UserConverter {

	public static User convert(RegisterDto dto) {
		User user = new User();
		user.setNom(dto.getNom());
		user.setEmail(dto.getEmail());
		user.setPwd(dto.getPwd());
		user.setBirthDate(dto.getBirthDate());
		return user;
	}
	
	public static RegisterDto convert (User user) {
		RegisterDto dto = new RegisterDto();
		dto.setNom(user.getNom());
		dto.setEmail(user.getEmail());
		dto.setPwd(user.getPwd());
		dto.setBirthDate(user.getBirthDate());
		return dto;
	}

	public static List<User> convertt(List<RegisterDto> dtos) {
		List<User> listUsers = new ArrayList<>();
		for(RegisterDto dto : dtos) {
			listUsers.add(UserConverter.convert(dto));
		}
		return listUsers;
	}

	public static List<RegisterDto> convert(List<User> users) {
		List<RegisterDto> listDtos = new ArrayList<>();
		for(User user : users) {
			listDtos.add(UserConverter.convert(user));
		}
		return listDtos;
	}
}
