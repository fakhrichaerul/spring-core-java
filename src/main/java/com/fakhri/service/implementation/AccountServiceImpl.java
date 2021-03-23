package com.fakhri.service.implementation;

import com.fakhri.domain.Account;
import com.fakhri.repository.AccountRepository;
import com.fakhri.service.AccountService;

import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public void transferMoney(Long sourceId, Long destinationId, BigDecimal balance) {
        Account sourceAccount = accountRepository.find(sourceId);
        Account destinationAccount = accountRepository.find(destinationId);
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(balance));
        destinationAccount.setBalance(destinationAccount.getBalance().add(balance));

        accountRepository.update(sourceAccount);
        accountRepository.update(destinationAccount);
    }

    @Override
    public Account getAccount(Long id) {

        return accountRepository.find(id);
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
