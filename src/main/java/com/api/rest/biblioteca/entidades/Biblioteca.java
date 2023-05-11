package com.api.rest.biblioteca.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "biblioteca")
public class Biblioteca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String nombre;

	@NotNull
	private String apellido;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Users users;
	@OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL)
	private Set<Libro> libros = new HashSet<>();

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
		for(Libro libro : libros) {
			libro.setBiblioteca(this);
		}
	}

	// geters para obtener las bibilioteca de tal usuario


}
