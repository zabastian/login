package com.example.demo.homePage;

import com.example.demo.entity.User;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class HomePage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public HomePage(String message, User user) {
        this.message = message;
        this.user = user;
    }


    protected HomePage() {}
}
