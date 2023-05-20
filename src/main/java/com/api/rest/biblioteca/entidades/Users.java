package com.api.rest.biblioteca.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.api.rest.biblioteca.entidades.Status;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Users")
@EntityListeners(AuditingEntityListener.class)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    @Column()
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date createdAt;

    @Column()
    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    private Date updatedAt;



    // relacionando tablas
    // relacion con tablas notebook o libro usuario tiene varias bibliotecas




    // relacion  con tabla status, usuario uno a uno usuario tiene un estado
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_idstatus")
    private Status userStatus;


    public Users() {
    }
    public Users( String name, String email,String password, Status status,Date createdAt,Date updatedAt) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.userStatus = status;
        this.createdAt= createdAt;
        this.updatedAt=updatedAt;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Status getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Status userStatus) {
        this.userStatus = userStatus;
    }

// metodo para obtener todas las bibliotecas e un usuario por su id

}
