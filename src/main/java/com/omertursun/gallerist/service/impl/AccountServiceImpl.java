package com.omertursun.gallerist.service.impl;

import com.omertursun.gallerist.dto.DtoAccount;
import com.omertursun.gallerist.dto.DtoAccountUI;
import com.omertursun.gallerist.model.Account;
import com.omertursun.gallerist.repository.AccountRepository;
import com.omertursun.gallerist.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(DtoAccountUI dtoAccountUI){
        Account account = new Account();
        account.setAccountNo(dtoAccountUI.getAccountNo());
        account.setIban(dtoAccountUI.getIban());
        account.setCreateTime(new Date());
        return account;

    }

    @Override
    public DtoAccount saveAccount(DtoAccountUI dtoAccountUI) {
        DtoAccount dtoAccount = new DtoAccount();
       Account savedAccount =  accountRepository.save(createAccount(dtoAccountUI));
       BeanUtils.copyProperties(savedAccount, dtoAccount);

       return dtoAccount;
    }
}
