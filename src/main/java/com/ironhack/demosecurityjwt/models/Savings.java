package com.ironhack.demosecurityjwt.models;
import com.ironhack.demosecurityjwt.enums.Status;
import jakarta.persistence.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
public class Savings extends Account{
    private Money balance;
    private Long secretKey;
    private Money minimumBalance = new Money(new BigDecimal("1000")) ;

    private LocalDate creationDate = LocalDate.now();
    private Money interestRate = new Money(new BigDecimal("0.0025"));
    private Status status = Status.ACTIVE;


    public Savings() {
    }

    public Savings(Money balance, Long secretKey, Money minimumBalance, LocalDate creationDate, Money interestRate, Status status) {
        setBalance(balance);
        setSecretKey(secretKey);
        setMinimumBalance(minimumBalance);
        setCreationDate(creationDate);
        setInterestRate(interestRate);
        setStatus(status);
    }

    @Override
    public Money getBalance() {
        return balance;
    }

    @Override
    public void setBalance(Money balance) {
        this.balance = balance;
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

    public void setMinimumBalance(Money minimumBalance) {
        if( minimumBalance < 100){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Minimum balance should be over 100");
        }
        this.minimumBalance = minimumBalance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Money getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Money interestRate) {
        if(interestRate > 0.5 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Interest rate can't be over 0.5");
        }
        this.interestRate = interestRate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
