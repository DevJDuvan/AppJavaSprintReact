package com.api.rest.biblioteca.repositorios;

import com.api.rest.biblioteca.entidades.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query("select l from Users l where l.email='jose1996@gmail.com'")
    List<Users> findByName();

}

