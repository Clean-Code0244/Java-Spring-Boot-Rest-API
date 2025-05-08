package com.omertursun.gallerist.service.impl;

import com.omertursun.gallerist.dto.DtoAddress;
import com.omertursun.gallerist.dto.DtoAddressUI;
import com.omertursun.gallerist.model.Address;
import com.omertursun.gallerist.repository.AddressRepository;
import com.omertursun.gallerist.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressServiceImpl implements IAddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    private Address createAddress(DtoAddressUI dtoAddressUI) {
        Address address = new Address();
        address.setCreateTime(new Date());
        address.setCity(dtoAddressUI.getCity());
        address.setDistrict(dtoAddressUI.getDistrict());
        address.setNeighborhood(dtoAddressUI.getNeighborhood());
        BeanUtils.copyProperties(dtoAddressUI, address);
        return address;
    }
    @Override
    public DtoAddress saveAddress(DtoAddressUI dtoAddressUI) {
        DtoAddress dtoAddress = new DtoAddress();
        Address address = addressRepository.save(createAddress(dtoAddressUI));
        BeanUtils.copyProperties(address, dtoAddress);
        return dtoAddress;
    }
}
