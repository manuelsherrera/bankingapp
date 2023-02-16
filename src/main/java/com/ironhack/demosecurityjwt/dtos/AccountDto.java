package com.ironhack.demosecurityjwt.dtos;

import java.time.LocalDate;

public class AccountDto {
    private String balance;
    private Long primaryOwnerId;
    private Long secondaryOwnerId;

    private LocalDate dateOfBirth;

    private String minimumBalance;
    private Long secretKey;
    private String monthlyMaintenanceFee;
    private String creditLimit;

    public AccountDto(String balance, Long primaryOwnerId, Long secondaryOwnerId, String minimumBalance, Long secretKey, String monthlyMaintenanceFee, String creditLimit, LocalDate dateOfBirth) {
        setBalance(balance);
        setPrimaryOwnerId(primaryOwnerId);
        setSecondaryOwnerId(secondaryOwnerId);
        setMinimumBalance(minimumBalance);
        setSecretKey(secretKey);
        setMonthlyMaintenanceFee(monthlyMaintenanceFee);
        setCreditLimit(creditLimit);
        setDateOfBirth(dateOfBirth);
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Long getPrimaryOwnerId() {
        return primaryOwnerId;
    }

    public void setPrimaryOwnerId(Long primaryOwnerId) {
        this.primaryOwnerId = primaryOwnerId;
    }

    public Long getSecondaryOwnerId() {
        return secondaryOwnerId;
    }

    public void setSecondaryOwnerId(Long secondaryOwnerId) {
        this.secondaryOwnerId = secondaryOwnerId;
    }

    public String getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(String minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Long getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(Long secretKey) {
        this.secretKey = secretKey;
    }

    public String getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(String monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
