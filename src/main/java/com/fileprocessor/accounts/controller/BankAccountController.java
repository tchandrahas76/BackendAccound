package com.fileprocessor.accounts.controller;

import com.fileprocessor.accounts.dto.AccountRequest;
import com.fileprocessor.accounts.dto.AccountResponse;
import com.fileprocessor.accounts.dto.DepositRequest;
import com.fileprocessor.accounts.dto.WidthdrawRequest;
import com.fileprocessor.accounts.entity.Accounts;
import com.fileprocessor.accounts.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/banks")
public class BankAccountController {

    @Autowired
    private AccountsService accountsService;

    @PostMapping ("/createAccounts")
    public ResponseEntity<AccountResponse> createAccounts(@RequestBody AccountRequest accountRequest){
        AccountResponse response = accountsService.createAccount(accountRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAccount/{id}")
    public ResponseEntity<Accounts> getAllAccountById(@PathVariable("id") Long id){
        Accounts response = accountsService.getAccountById(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/allaccounts")
    public ResponseEntity<List<Accounts>> getAllAccounts(){

        List<Accounts> response = accountsService.getAllAccounts();
        return ResponseEntity.ok(response);
    }

    // Update Account
    @PostMapping("/updateAccount")
    public ResponseEntity<Accounts> updateAccountById(@RequestParam("id") Long id, @RequestBody AccountRequest accountRequest){
        Accounts response = accountsService.updateAccountById(id,accountRequest);
        return ResponseEntity.ok(response);
    }


    //Delete Account
    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable("id") Long id){
        String response = accountsService.deleteAccountById(id);
        return ResponseEntity.ok(response);
    }
    //deposit Amount

    @PostMapping("/depositMoney")
    public ResponseEntity<String> depositMoney(@RequestParam("id") Long id, @RequestBody
    DepositRequest depositRequest){
        String result = accountsService.depositAmount(id,depositRequest);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/widthdrawMoney")
    public ResponseEntity<String> widthdrawMoney(@RequestParam("id") Long id, @RequestBody
    WidthdrawRequest widthdrawRequest){
        String result = accountsService.widthdrawAmount(id,widthdrawRequest);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/checkBalance")
    public ResponseEntity<String> widthdrawMoney(@RequestParam("id") Long id){
        String result = accountsService.checkBalance(id);
        return ResponseEntity.ok(result);
    }


    // check balance



}
