package com.ironhack.demosecurityjwt.models;

import jakarta.persistence.Entity;

import java.util.Collection;

@Entity
public class Admin extends User {
    public Admin() {
    }

    public Admin(String name, String username, String password, Collection<Role> roles) {
        super(name, username, password, roles);
    }
}
