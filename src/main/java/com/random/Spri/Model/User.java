package com.random.Spri.Model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.util.Set;


@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(unique = true, name = "userName")
    private String userName;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(nullable = false, name = "email")
    @ColumnDefault("'default@email.com'")
    private String email;

    @ManyToMany(mappedBy = "users")
    private Set<Product> products;

    public User(){

    }
}
