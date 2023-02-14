package com.ironhack.demosecurityjwt.models;

import jakarta.persistence.Entity;

import java.util.Collection;

@Entity
public class ThirdParty extends User{

    private String hashedKey;

    public ThirdParty() {
    }

    public ThirdParty(Long id, String name, Collection<Role> roles, String hashedKey) {
        super(id, name, roles);
        this.hashedKey = hashedKey;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }
}
