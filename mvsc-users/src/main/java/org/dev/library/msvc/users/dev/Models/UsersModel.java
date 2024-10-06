package org.dev.library.msvc.users.dev.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UsersModel {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Firstname")
    private String firstname;

    @Column(name = "Lastname")
    private String lastname;

    @Column(name = "Birth")
    private Date birth;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Username", unique = true)
    private String username;

    @Column(name = "Phonenumber")
    private String phonenumber;

    @Column(name = "Address")
    private String address;

    @Column(name = "Password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "Created_by")
    private UsersModel createdBy;

    @Column(name = "Created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "Updated_by")
    private UsersModel updatedBy;

    @Column(name = "Updated_at")
    private Date updatedAt;

}