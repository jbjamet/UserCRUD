package com.fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.controller.dto.LoginDto;
import com.fr.adaming.converters.UserConverter;
import com.fr.adaming.dto.RegisterDto;
import com.fr.adaming.entity.User;
import com.fr.adaming.service.UserService;

@RestController
@RequestMapping(path = "api/users")
public class UserController {

	@Autowired
	private UserService service;

//	@GetMapping(path = "/get-all")
	@RequestMapping(path = "/get-all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		System.out.println("***************** ça a marché *****************");
		return service.getAll();
	}

//	@GetMapping(path = "/get-id/{idx}")
	@RequestMapping(path = "/{idx}/get-id/", method = RequestMethod.GET)
	public User getOneById(@PathVariable(name = "idx") int id) {
		return service.getById(id);
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String create(@RequestBody User user) {
		if (service.save(user) != null) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestBody LoginDto loginDto) {
		System.out.println(loginDto);
		if (service.login(loginDto.getEmail(), loginDto.getPwd()) != null) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@PostMapping(path = "/register")
	public String register(@RequestBody RegisterDto dto) {
		if (service.save(UserConverter.convert(dto)) != null) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@RequestMapping(path = "/{id}/delete/", method = RequestMethod.DELETE)
	public String deleteById(@PathVariable int id) {
		service.deleteById(id);
		return "Object deleted";
	}

}
