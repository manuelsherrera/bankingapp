package com.ironhack.demosecurityjwt.models;

import jakarta.persistence.Entity;

@Entity
public class CreditCard extends Account{

    private Integer creditLimit = 100;

    private Double interestRate = 0.2;

    public CreditCard() {
    }

    public CreditCard(Integer creditLimit, Double interestRate) {
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        if( creditLimit > 100000){
            throw new IllegalArgumentException("Credit limit can't be higher than 100000");
        }
        this.creditLimit = creditLimit;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        if(interestRate < 0.1){
            throw new IllegalArgumentException("Interest rate shouldn't be lower than 0.1");
        }
        this.interestRate = interestRate;
    }
}
