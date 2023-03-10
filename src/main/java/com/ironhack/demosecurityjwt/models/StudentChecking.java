package com.ironhack.demosecurityjwt.models;

import com.ironhack.demosecurityjwt.enums.Status;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class StudentChecking extends Account {

    private Long secretKey;
    private LocalDate creationDate = LocalDate.now();

    private Status status = Status.ACTIVE;

    public StudentChecking() {
    }

    public StudentChecking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Long secretKey) {
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
