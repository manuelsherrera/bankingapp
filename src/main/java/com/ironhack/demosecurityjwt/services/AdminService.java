package com.ironhack.demosecurityjwt.services;

import com.ironhack.demosecurityjwt.dtos.AccountDto;
import com.ironhack.demosecurityjwt.models.*;
import com.ironhack.demosecurityjwt.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class AdminService {
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    public Savings newSavingAccount(AccountDto accountDto){
        AccountHolder primaryOwner = accountHolderRepository.findById(accountDto.getPrimaryOwnerId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Primary owner not found"));
        AccountHolder secondaryOwner = null;
        if (accountDto.getSecondaryOwnerId() != null && accountHolderRepository.findById(accountDto.getSecondaryOwnerId()).isPresent()){
            secondaryOwner = accountHolderRepository.findById(accountDto.getSecondaryOwnerId()).get();
        }
        Savings savings = new Savings(new Money(new BigDecimal(accountDto.getBalance())), primaryOwner, secondaryOwner, accountDto.getSecretKey(), new Money(new BigDecimal(accountDto.getMinimumBalance())) );
        return savingsRepository.save(savings);

    }

    public CreditCard newCreditCard(AccountDto accountDto){
        AccountHolder primaryOwner = accountHolderRepository.findById(accountDto.getPrimaryOwnerId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Primary owner not found"));
        AccountHolder secondaryOwner = null;
        if (accountDto.getSecondaryOwnerId() != null && accountHolderRepository.findById(accountDto.getSecondaryOwnerId()).isPresent()){
            secondaryOwner = accountHolderRepository.findById(accountDto.getSecondaryOwnerId()).get();
        }
        CreditCard creditCard = new CreditCard(new Money(new BigDecimal(accountDto.getBalance())), primaryOwner, secondaryOwner, new Money(new BigDecimal(accountDto.getCreditLimit())));
        return creditCardRepository.save(creditCard);

    }
    // revisar solo devuleve checking.
    public Checking newChecking(AccountDto accountDto){
        AccountHolder primaryOwner = accountHolderRepository.findById(accountDto.getPrimaryOwnerId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Primary owner not found"));
        AccountHolder secondaryOwner = null;
        if (accountDto.getSecondaryOwnerId() != null && accountHolderRepository.findById(accountDto.getSecondaryOwnerId()).isPresent()){
            secondaryOwner = accountHolderRepository.findById(accountDto.getSecondaryOwnerId()).get();
        }
        Checking checking = new Checking(new Money(new BigDecimal(accountDto.getBalance())), primaryOwner, secondaryOwner, accountDto.getSecretKey(), new Money(new BigDecimal(accountDto.getMinimumBalance())),new Money(new BigDecimal(accountDto.getMonthlyMaintenanceFee())));
        return checkingRepository.save(checking);

    }

}
