package com.example.easynotes.controller;
import com.example.easynotes.servicesimplement.EncryptServicesImplement;
import org.springframework.http.HttpStatus;
import com.example.easynotes.model.Users;
import com.example.easynotes.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
	  @Autowired
	 
	  private final  UsersRepository UserRepository;

	  UserController(UsersRepository repository) {
	    this.UserRepository = repository;
	  }
	@PostMapping(value = "/register",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
		EncryptServicesImplement encyptPasswordUser = new EncryptServicesImplement();
		String HashPass = encyptPasswordUser.EncryptPassword("holla");
		System.out.print(HashPass);
		  Users usuario = new Users(user.getId(), user.getName(), user.getEmail(), user.getPassword(),
				                    user.getStatus(),user.getCreatedAt(),user.getUpdatedAt());
UserRepository.save(usuario);
		return new ResponseEntity<Users>(usuario,HttpStatus.OK);
	}
	@GetMapping(value = "/User")
	public List<Users> getAllUsers() {
		return UserRepository.findAll();
	}
	  
	public UsersRepository getUserRepository() {
		return UserRepository;
	}
}


