package com.ironhack.demosecurityjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class AccountHolder extends User {
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "primaryOwner")
    @JsonIgnore
    private List<Account> primaryOwnerList = new ArrayList<>();
    @Embedded
    /*@AttributeOverrides({
            @AttributeOverride(name="streetName",column=@Column(name="primary_street_name")),
            @AttributeOverride(name="streetNumber",column=@Column(name="primary_street_number")),
            @AttributeOverride(name="cityName",column=@Column(name="primary_city_name")),
            @AttributeOverride(name="zipCode",column=@Column(name="primary_zip_code")),
    })*/
    private Address address;

    @OneToMany(mappedBy = "secondaryOwner")
    @JsonIgnore
    private List<Account> secondaryOwnerList = new ArrayList<>();
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="streetName",column=@Column(name="mailing_street_name")),
            @AttributeOverride(name="streetNumber",column=@Column(name="mailing_street_number")),
            @AttributeOverride(name="cityName",column=@Column(name="mailing_city_name")),
            @AttributeOverride(name="zipCode",column=@Column(name="mailing_zip_code")),
    })
    private Address mailingAddress;

    public AccountHolder() {
    }

    public AccountHolder(String name, String username, String password, Collection<Role> roles, LocalDate dateOfBirth, Address address, Address mailingAddress) {
        super(name, username, password, roles);
        setDateOfBirth(dateOfBirth);
        setAddress(address);
        setMailingAddress(mailingAddress);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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
