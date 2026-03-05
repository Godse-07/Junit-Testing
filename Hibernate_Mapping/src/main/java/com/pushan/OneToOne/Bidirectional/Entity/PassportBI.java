package com.pushan.OneToOne.Bidirectional.Entity;
import jakarta.persistence.*;

@Entity
public class PassportBI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UsersBI user;

    public PassportBI() {}

    public PassportBI(String passportNumber, UsersBI user) {
        this.passportNumber = passportNumber;
        this.user = user;
    }

    public Long getId() { return id; }

    public String getPassportNumber() { return passportNumber; }

    public UsersBI getUser() { return user; }

    public void setUser(UsersBI user) {
        this.user = user;
    }
}