package com.example.easynotes.controller;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Status;
import com.example.easynotes.servicesimplement.EncryptServicesImplement;
import org.springframework.http.HttpStatus;
import com.example.easynotes.model.Users;
import com.example.easynotes.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
	  @Autowired

	  private final  UsersRepository UserRepository;

	  UserController(UsersRepository repository) {
	    this.UserRepository = repository;
	  }
	@PostMapping(value = "/register_User",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {

		System.out.print(user.getUserStatus());
		EncryptServicesImplement encyptPasswordUser = new EncryptServicesImplement();
		String HashPass = encyptPasswordUser.EncryptPassword("holla");

		return new ResponseEntity<Users>(UserRepository.save(user),HttpStatus.OK);
	}
	@GetMapping(value = "/UserbyName")
	public List<Users> getbyName() {
		List<Users> UsersD = new ArrayList<Users>();
		UserRepository.findByName().forEach(Users -> UsersD.add(Users));
		return UsersD;
	}

	@GetMapping(value = "/UserAllUsers")
	public ResponseEntity<List<Users>> getAllUsers() {
		return new ResponseEntity<>(UserRepository.findAll(), HttpStatus.OK);
	}


	  
	public UsersRepository getUserRepository() {
		return UserRepository;
	}
}


