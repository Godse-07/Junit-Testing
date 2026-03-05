package com.pushan.OneToOne.Bidirectional.Entity;

import jakarta.persistence.*;

@Entity
public class UsersBI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "user")
    private PassportBI passport;

    public UsersBI() {}

    public UsersBI(String name) {
        this.name = name;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public PassportBI getPassport() { return passport; }

    public void setPassport(PassportBI passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "UsersBI{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passport=" + passport +
                '}';
    }
}