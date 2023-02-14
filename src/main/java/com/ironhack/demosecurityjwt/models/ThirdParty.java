package com.ironhack.demosecurityjwt.models;

import jakarta.persistence.Entity;

import java.util.Collection;

@Entity
public class ThirdParty extends User{

    private String hashedKey;

    public ThirdParty() {
    }

    public ThirdParty(String name, String username, String password, Collection<Role> roles, String hashedKey) {
        super(name, username, password, roles);
        setHashedKey(hashedKey);
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }
}
