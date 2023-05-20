package com.api.rest.biblioteca.controladores;

import com.api.rest.biblioteca.entidades.Biblioteca;
import com.api.rest.biblioteca.entidades.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import com.api.rest.biblioteca.entidades.Users;
import com.api.rest.biblioteca.repositorios.UsersRepository;
import com.api.rest.biblioteca.servicesimplement.EncryptServicesImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin( origins = "*" )
@RestController
@RequestMapping("/api/users")
public class UserController {
	  @Autowired

	  private final  UsersRepository UserRepository;

	  UserController(UsersRepository repository) {
	    this.UserRepository = repository;
	  }
	Date date = new Date();
	@GetMapping
	public ResponseEntity<Page<Users>> listarUsers(Pageable pageable){
		return ResponseEntity.ok(UserRepository.findAll(pageable));
	}
	@PostMapping(value = "/register_User",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})


	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
		EncryptServicesImplement encyptPasswordUser = new EncryptServicesImplement();
		String HashPass = encyptPasswordUser.EncryptPassword("holla");
		System.out.print(HashPass);
		boolean ver = encyptPasswordUser.veryfyPassword("holla",HashPass);
		System.out.print("hhjhjhjhjhjhj" + ver);
Users userdata = new Users(user.getName(),user.getEmail(),user.getPassword(),user.getUserStatus(),new Date(),new Date());
		return new ResponseEntity<Users>(UserRepository.save(userdata),HttpStatus.OK);
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

	@GetMapping("userbyid/{id}")
	public ResponseEntity<Users> GetUserById(@PathVariable Integer id){
		Optional<Users> libroOptional = UserRepository.findById(id);

		if(!libroOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.ok(UserRepository.getById(id));

	}
}


