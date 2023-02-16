package com.ironhack.demosecurityjwt.models;


import com.ironhack.demosecurityjwt.enums.Status;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Money balance;
    @ManyToOne
    @JoinColumn(name = "primary_owner_id")
    private AccountHolder primaryOwner;
    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    private AccountHolder secondaryOwner; //optional
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount",column=@Column(name="penalty_fee_amount")),
            @AttributeOverride(name="currency",column=@Column(name="penalty_fee_currency")),
    })
    private final Money penaltyFee = new Money(new BigDecimal("40"));

    public Account() {
    }

    public Account(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        setBalance(balance);
        setPrimaryOwner(primaryOwner);
        setSecondaryOwner(secondaryOwner);

    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public Money getPenaltyFee() {
        return penaltyFee;
    }







}
