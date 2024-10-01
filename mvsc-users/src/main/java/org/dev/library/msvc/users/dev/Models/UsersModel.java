package org.dev.library.msvc.users.dev.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Users")
@Data
public class UsersModel {

    @Id
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

    @Column(name = "PhoneNumber")
    private String phoneNumber;

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
