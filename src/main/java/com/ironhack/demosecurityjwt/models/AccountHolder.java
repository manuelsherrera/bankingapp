package com.ironhack.demosecurityjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class AccountHolder extends User {
    private String dateOfBirth;
    @OneToMany(mappedBy = "primaryOwner")
    @JsonIgnore
    private List<Account> primaryOwnerList = new ArrayList<>();
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street_name",column=@Column(name="primary_street_name")),
            @AttributeOverride(name="street_number",column=@Column(name="primary_street_number")),
            @AttributeOverride(name="city_name",column=@Column(name="primary_city_name")),
            @AttributeOverride(name="zip_code",column=@Column(name="primary_zip_code")),
    })
    private Address address;

    @OneToMany(mappedBy = "secondaryOwner")
    @JsonIgnore
    private List<Account> secondaryOwnerList = new ArrayList<>();
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street_name",column=@Column(name="mailing_street_name")),
            @AttributeOverride(name="street_number",column=@Column(name="mailing_street_number")),
            @AttributeOverride(name="city_name",column=@Column(name="mailing_city_name")),
            @AttributeOverride(name="zip_code",column=@Column(name="mailing_zip_code")),
    })
    private Address mailingAddress;

    public AccountHolder() {
    }

    public AccountHolder(String name, String username, String password, Collection<Role> roles, String dateOfBirth, Address address, Address mailingAddress) {
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

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public List<Account> getPrimaryOwnerList() {
        return primaryOwnerList;
    }

    public void setPrimaryOwnerList(List<Account> primaryOwnerList) {
        this.primaryOwnerList = primaryOwnerList;
    }

    public List<Account> getSecondaryOwnerList() {
        return secondaryOwnerList;
    }

    public void setSecondaryOwnerList(List<Account> secondaryOwnerList) {
        this.secondaryOwnerList = secondaryOwnerList;
    }
}
