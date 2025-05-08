package com.omertursun.gallerist.controller.impl;

import com.omertursun.gallerist.controller.IRestAccountController;
import com.omertursun.gallerist.controller.RestBaseController;
import com.omertursun.gallerist.controller.RootEntity;
import com.omertursun.gallerist.dto.DtoAccount;
import com.omertursun.gallerist.dto.DtoAccountUI;
import com.omertursun.gallerist.service.IAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class RestAccountController extends RestBaseController implements IRestAccountController {

    private IAccountService accountService;

    public RestAccountController(IAccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/save")
    @Override
    public RootEntity<DtoAccount> createAccount(DtoAccountUI dtoAccountUI) {
        return ok(accountService.saveAccount(dtoAccountUI));
    }
}
