package org.dev.library.msvc.users.dev.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Entity
@Builder
@Table(name = "Users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "Email", unique = true, nullable = false)
    private String email;

    @Column(name = "Username", unique = true, nullable = false)
    private String username;

    @Column(name = "Phonenumber")
    private String phonenumber;

    @Column(name = "Address")
    private String address;

    @Column(name = "Password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "Created_by", updatable = false)
    private UsersModel createdBy;

    @CreationTimestamp
    @Column(name = "Created_at", updatable = false)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "Updated_by", insertable = false)
    private UsersModel updatedBy;

    @UpdateTimestamp
    @Column(name = "Updated_at", insertable = false)
    private Date updatedAt;
}