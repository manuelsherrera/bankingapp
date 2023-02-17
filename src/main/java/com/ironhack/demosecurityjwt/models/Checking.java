package com.ironhack.demosecurityjwt.models;

import com.ironhack.demosecurityjwt.enums.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Checking extends Account{

 private Long secretKey;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount",column=@Column(name="minimum_amount")),
            @AttributeOverride(name="currency",column=@Column(name="minimum_currency")),
    })
 private final Money minimumBalance = new Money(new BigDecimal("250"));

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount",column=@Column(name="maintenance_fee_amount")),
            @AttributeOverride(name="currency",column=@Column(name="maintenance_fee_currency")),
    })

 private final Money monthlyMaintenanceFee = new Money(new BigDecimal("12"));//

 private LocalDate creationDate = LocalDate.now();

 private Status status = Status.ACTIVE;

    public Checking() {
    }

    public Checking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Long secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        setSecretKey(secretKey);
        setCreationDate(creationDate);
        setStatus(status);
    }

    public Long getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(Long secretKey) {
        this.secretKey = secretKey;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }


    public Money getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }




    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
