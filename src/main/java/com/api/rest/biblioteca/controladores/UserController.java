package com.api.rest.biblioteca.controladores;

import com.api.rest.biblioteca.entidades.Biblioteca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import com.api.rest.biblioteca.entidades.Users;
import com.api.rest.biblioteca.repositorios.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	  @Autowired

	  private final  UsersRepository UserRepository;

	  UserController(UsersRepository repository) {
	    this.UserRepository = repository;
	  }

	@GetMapping
	public ResponseEntity<Page<Users>> listarUsers(Pageable pageable){
		return ResponseEntity.ok(UserRepository.findAll(pageable));
	}
	@PostMapping(value = "/register_User",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {

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


