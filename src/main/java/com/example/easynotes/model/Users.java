package com.example.easynotes.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "Users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column (unique = true,nullable = false)
private long id;

@Column (nullable = false)
private String name;



    @Column (nullable = false)
private String email;

    @Column (nullable = false)
    private String otro;

    @Column (nullable = false)
    private String otros;

    @Column (nullable = false)
private String password;
@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    // relacionando tablas
    // relacion con tablas notebook o libro usuario tiene varios libros
    @OneToMany( fetch= FetchType.LAZY , mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notebook> notebook;
    // relacion  con tabla status, usuario uno a uno usuario tiene un estado
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_idstatus")
     private Status userStatus;
    public Users() {
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }



    public Users(long id, String name, String email, String otro, String otros, String password, Status id_status, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.otro= otro;
        this.otros= otros;
        this.password = password;
        this.userStatus =id_status;
        this.createdAt= createdAt;
        this.updatedAt=updatedAt;
    }

    public Long getId() {
    return id;
}

public void setId(Long id) {
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
    this.password= password;
}

    public Status getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Status userStatus) {
        this.userStatus = userStatus;
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


    
}
