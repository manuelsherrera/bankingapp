package com.ironhack.demosecurityjwt.models;


import com.ironhack.demosecurityjwt.enums.Status;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Money balance;
    @ManyToOne
    @JoinColumn(name = "primary_owner_id")
    private User primaryOwner;
    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    private User secondaryOwner; //optional

    private Integer penaltyFee = 40;

    public Account() {
    }

    public Account(Money balance, User primaryOwner, User secondaryOwner, Integer penaltyFee) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.penaltyFee = penaltyFee;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public User getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(User primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public User getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(User secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public Integer getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(Integer penaltyFee) {
        this.penaltyFee = penaltyFee;
    }







}