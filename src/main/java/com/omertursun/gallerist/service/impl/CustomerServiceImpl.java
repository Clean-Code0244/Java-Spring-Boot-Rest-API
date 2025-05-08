package com.omertursun.gallerist.service.impl;

import com.omertursun.gallerist.dto.DtoAccount;
import com.omertursun.gallerist.dto.DtoAddress;
import com.omertursun.gallerist.dto.DtoCustomer;
import com.omertursun.gallerist.dto.DtoCustomerUI;
import com.omertursun.gallerist.exception.BaseException;
import com.omertursun.gallerist.exception.ErrorMessage;
import com.omertursun.gallerist.exception.MessageType;
import com.omertursun.gallerist.model.Account;
import com.omertursun.gallerist.model.Address;
import com.omertursun.gallerist.model.Customer;
import com.omertursun.gallerist.repository.AddressRepository;
import com.omertursun.gallerist.repository.CustomerRepository;
import com.omertursun.gallerist.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private AddressRepository addressRepository;
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(AddressRepository addressRepository, CustomerRepository customerRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    private Customer createCustomer(DtoCustomerUI dtoCustomerUI) {
        Customer customer = new Customer();
        customer.setCreateTime(new Date());
        Optional<Address> address = addressRepository.findById(dtoCustomerUI.getAddress().getId());
        if(address.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.INVALID_ADDRESS,address.get().getId().toString()));
        }
        customer.setAddress(address.get());
        Optional<Account> account = addressRepository.getAddressById(dtoCustomerUI.getAccount().getId());
        if(account.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.INVALID_ACCOUNT,account.get().getId().toString()));
        }
        customer.setAccount(account.get());
        return customer;
    }
    @Override
    public DtoCustomer saveCustomer(DtoCustomerUI dtoCustomerUI) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        DtoAccount dtoAccount = new DtoAccount();


      Customer customer = customerRepository.save(createCustomer(dtoCustomerUI));
      BeanUtils.copyProperties(customer, dtoCustomer);
      BeanUtils.copyProperties(customer.getAddress(), dtoAccount);
      BeanUtils.copyProperties(customer.getAccount(), dtoAccount);
      dtoCustomer.setAddress(dtoAddress);
      dtoCustomer.setAccount(dtoAccount);


      return dtoCustomer;
    }
}
