package com.ironhack.demosecurityjwt.services;
import com.ironhack.demosecurityjwt.dtos.AccountDto;
import com.ironhack.demosecurityjwt.models.*;
import com.ironhack.demosecurityjwt.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
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
    @Autowired
    private AccountRepository accountRepository;

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
    public Account newAccount(AccountDto accountDto){
        AccountHolder primaryOwner = accountHolderRepository.findById(accountDto.getPrimaryOwnerId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Primary owner not found"));
        AccountHolder secondaryOwner = null;
        if (accountDto.getSecondaryOwnerId() != null && accountHolderRepository.findById(accountDto.getSecondaryOwnerId()).isPresent()){
            secondaryOwner = accountHolderRepository.findById(accountDto.getSecondaryOwnerId()).get();
        }

        LocalDate dateOfBirth = primaryOwner.getDateOfBirth();
        LocalDate now = LocalDate.now();
        Period age = Period.between(dateOfBirth, now);

        if (age.getYears() >= 24){

            Checking checking = new Checking(new Money(new BigDecimal(accountDto.getBalance())), primaryOwner, secondaryOwner, accountDto.getSecretKey());
            return checkingRepository.save(checking);

        } else if (age.getYears() > 0) {
            StudentChecking studentChecking = new StudentChecking(new Money(new BigDecimal(accountDto.getBalance())), primaryOwner, secondaryOwner, accountDto.getSecretKey());

            return studentCheckingRepository.save(studentChecking);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer age should be over 1 year old to create an account");
        }

    }

    public void deleteAccount(Long id) {

        if (accountRepository.findById(id).isPresent()){
            accountRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer account not found ");
        }
    }

    public Account updateBalance(Money newBalance, Long id){

        if (accountRepository.findById(id).isPresent()){
            Account account = accountRepository.findById(id).get();
            account.setBalance(newBalance);
            return accountRepository.save(account);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No account found with the given id");
        }
    }

    public Money getBalance(Long id){
        if (accountRepository.findById(id).isPresent()){
            Account account = accountRepository.findById(id).get();
            return account.getBalance();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No account found with the given id");
        }
    }
}
