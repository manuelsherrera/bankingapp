package com.ironhack.demosecurityjwt.models;
import com.ironhack.demosecurityjwt.enums.Status;
import jakarta.persistence.Entity;
import java.time.LocalDate;


@Entity
public class Savings extends Account{
    private Money balance;
    private Long secretKey;
    private Integer minimumBalance = 1000;

    private LocalDate creationDate = LocalDate.now();
    private Double interestRate = 0.0025;
    private Status status = Status.ACTIVE;


    public Savings() {
    }

    public Savings(Money balance, Long secretKey, Integer minimumBalance, LocalDate creationDate, Double interestRate, Status status) {
        this.balance = balance;
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.creationDate = creationDate;
        this.interestRate = interestRate;
        this.status = status;
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

    public Integer getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Integer minimumBalance) {
        if( minimumBalance < 100){
            throw new IllegalArgumentException("Minimum balance should be over 100");
        }
        this.minimumBalance = minimumBalance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        if(interestRate > 0.5 ){
            throw new IllegalArgumentException("Interest rate can't be over 0.5");
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
