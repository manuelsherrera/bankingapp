package com.ironhack.demosecurityjwt.models;

import jakarta.persistence.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Entity
public class CreditCard extends Account{
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount",column=@Column(name="credit_limit_amount")),
            @AttributeOverride(name="currency",column=@Column(name="credit_limit_currency")),
    })
    private Money creditLimit = new Money(new BigDecimal("100"));

    private BigDecimal interestRate = new BigDecimal("0.2");

    public CreditCard() {
    }

    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money creditLimit) {
        super(balance, primaryOwner, secondaryOwner);
        setCreditLimit(creditLimit);//
        setInterestRate(interestRate);
    }

    public Money getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Money creditLimit) {
        if( creditLimit.getAmount().compareTo(new BigDecimal("100000")) == 1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credit limit can't be higher than 100000");
        }
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if(interestRate.compareTo(new BigDecimal("0.1")) == -1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Interest rate shouldn't be lower than 0.1");
        }
        this.interestRate = interestRate;
    }
}
