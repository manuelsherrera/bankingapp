package com.ironhack.demosecurityjwt.models;
import com.ironhack.demosecurityjwt.enums.Status;
import jakarta.persistence.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
public class Savings extends Account{
    private Long secretKey;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount",column=@Column(name="minimum_balance_amount")),
            @AttributeOverride(name="currency",column=@Column(name="minimum_balance_currency")),
    })
    private Money minimumBalance = new Money(new BigDecimal("1000")) ;

    private LocalDate creationDate = LocalDate.now();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount",column=@Column(name="interest_rate_amount")),
            @AttributeOverride(name="currency",column=@Column(name="interest_rate_currency")),
    })
    private Money interestRate = new Money(new BigDecimal("0.0025"));
    private Status status = Status.ACTIVE;


    public Savings() {
    }

    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee, Long secretKey, Money minimumBalance, LocalDate creationDate, Money interestRate, Status status) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.creationDate = creationDate;
        this.interestRate = interestRate;
        this.status = status;
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
        if( minimumBalance.getAmount().compareTo(new BigDecimal("100")) == -1){
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
        if(interestRate.getAmount().compareTo(new BigDecimal("0.5")) == 1){
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
