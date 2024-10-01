package org.dev.library.msvc.users.dev.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Users")
@Data
public class UsersModel {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Firstname")
    private String Firstname;

    @Column(name = "Lastname")
    private String Lastname;

    @Column(name = "Birthdate")
    private Date Birthdate;

    @Column(name = "Email")
    private String Email;

}
