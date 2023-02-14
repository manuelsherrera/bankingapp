package com.ironhack.demosecurityjwt.models;

import jakarta.persistence.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Entity
public class CreditCard extends Account{

    private Money creditLimit = new Money(new BigDecimal("100"));

    private Money interestRate = new Money(new BigDecimal("0.2"));

    public CreditCard() {
    }

    public CreditCard(Money balance, User primaryOwner, User secondaryOwner, Money penaltyFee, Money creditLimit, Money interestRate) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        setCreditLimit(creditLimit);//
        setInterestRate(interestRate);
    }

    public Money getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Money creditLimit) {
        if( creditLimit > 100000){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credit limit can't be higher than 100000");
        }
        this.creditLimit = creditLimit;
    }

    public Money getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Money interestRate) {
        if(interestRate < 0.1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Interest rate shouldn't be lower than 0.1");
        }
        this.interestRate = interestRate;
    }
}
