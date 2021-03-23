package com.fakhri.config;

import com.fakhri.repository.AccountRepository;
import com.fakhri.repository.implementation.AccountRepositoryImpl;
import com.fakhri.service.AccountService;
import com.fakhri.service.implementation.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public AccountRepository accountRepository(){
        return new AccountRepositoryImpl();
    }

    @Bean
    public AccountService accountService (AccountRepository accountRepository){
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setAccountRepository(accountRepository);
        return accountService;
    }
}
