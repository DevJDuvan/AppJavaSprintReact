package com.example.easynotes.repository;

import com.example.easynotes.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {
    @Query("select l from Notebook l where l.user.userStatus.name='active'")
    List<Notebook> findByuserStatus();


}

