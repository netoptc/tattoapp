package com.netoptc.tattoapp.modules.account.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netoptc.tattoapp.modules.account.entities.AccountEntity;
import com.netoptc.tattoapp.modules.account.repositories.AccountRepository;

@Service
public class CreateAccountService {

    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity<Object> execute(AccountEntity accountEntity) {
        try {
            System.out.println("ola mundo 2");
            this.accountRepository.findByUsernameOrEmail(accountEntity.getUsername(), accountEntity.getEmail())
                    .ifPresent((account) -> {
                        throw new Error("Account already exist");
                    });
            System.out.println(accountEntity);
            var account = this.accountRepository.save(accountEntity);
            return ResponseEntity.ok().body(account);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
