package com.ironhack.demosecurityjwt.models;

import jakarta.persistence.Entity;

import java.util.Collection;

@Entity
public class Admin extends User {
    public Admin() {
    }

    public Admin(Long id, String name, Collection<Role> roles) {
        super(id, name, roles);
    }



}
