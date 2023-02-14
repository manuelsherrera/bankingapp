package com.ironhack.demosecurityjwt.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

import java.util.Collection;

@Entity
public class AccountHolder extends User {
    private String dateOfBirth;

    @Embedded //
    private Address address;

    private String mailingAddress;

    public AccountHolder() {
    }

    public AccountHolder(String name, String username, String password, Collection<Role> roles, String dateOfBirth, Address address, String mailingAddress) {
        super(name, username, password, roles);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.mailingAddress = mailingAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
