package com.ironhack.demosecurityjwt.controllers;

import com.ironhack.demosecurityjwt.dtos.AccountDto;
import com.ironhack.demosecurityjwt.models.Account;
import com.ironhack.demosecurityjwt.models.CreditCard;
import com.ironhack.demosecurityjwt.models.Money;
import com.ironhack.demosecurityjwt.models.Savings;
import com.ironhack.demosecurityjwt.repositories.AccountRepository;
import com.ironhack.demosecurityjwt.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AdminService adminService;
    @PostMapping("/checking")
    @ResponseStatus(HttpStatus.CREATED)
    public Account newAccount(@RequestBody AccountDto accountDto) {

       return adminService.newAccount(accountDto);

    }

    @PostMapping("/savings")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings newSavingAccount(@RequestBody AccountDto accountDto) {
        return adminService.newSavingAccount(accountDto);
    }

    @PostMapping("/creditcard")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard newCreditCard(@RequestBody AccountDto accountDto) {
        return adminService.newCreditCard(accountDto);
    }

    @PostMapping("/update_balance")
    @ResponseStatus(HttpStatus.OK)
    public Money updateBalance(@RequestParam Long id, @RequestParam Money newBalance) {
        return adminService.updateBalance(newBalance, id).getBalance();
    }


    @DeleteMapping("/delete/account")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@RequestParam Long id) {
        adminService.deleteAccount(id);

    }
}
