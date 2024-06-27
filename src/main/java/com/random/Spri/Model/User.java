package com.random.Spri.Model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;


    public User(){

    }
}
