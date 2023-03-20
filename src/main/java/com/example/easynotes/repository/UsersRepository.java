package com.example.easynotes.repository;

import com.example.easynotes.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

    @Query ("select l from Users l where l.email='jose1996@gmail.com'")
    List<Users> findByName();
}

