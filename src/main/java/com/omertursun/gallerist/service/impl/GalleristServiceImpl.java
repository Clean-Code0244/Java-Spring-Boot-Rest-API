package com.omertursun.gallerist.service.impl;

import com.omertursun.gallerist.dto.DtoGallerist;
import com.omertursun.gallerist.dto.DtoGalleristUI;
import com.omertursun.gallerist.exception.BaseException;
import com.omertursun.gallerist.exception.ErrorMessage;
import com.omertursun.gallerist.exception.MessageType;
import com.omertursun.gallerist.model.Address;
import com.omertursun.gallerist.model.Gallerist;
import com.omertursun.gallerist.repository.AddressRepository;
import com.omertursun.gallerist.repository.GalleristRepository;
import com.omertursun.gallerist.service.IGalleristService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GalleristServiceImpl implements IGalleristService {

    private AddressRepository addressRepository;
    private GalleristRepository galleristRepository;
    public GalleristServiceImpl(AddressRepository addressRepository, GalleristRepository galleristRepository) {
        this.addressRepository = addressRepository;
        this.galleristRepository = galleristRepository;
    }

    private Gallerist createGallerist(DtoGalleristUI galleristUI){

        Gallerist gallerist = new Gallerist();
        gallerist.setFirstName(galleristUI.getFirstName());
        gallerist.setLastName(galleristUI.getLastName());

        Optional<Address> address = addressRepository.findById(galleristUI.getAddress().getId());
        if(address.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.INVALID_ADDRESS, "Address not found"));
        }
        gallerist.setAddress(address.get());



        return gallerist;
    }


    @Override
    public DtoGallerist saveGallerist(DtoGalleristUI dtoGalleristUI) {

        DtoGallerist dtoGallerist = new DtoGallerist();
        Gallerist gallerist = galleristRepository.save(createGallerist(dtoGalleristUI));
        BeanUtils.copyProperties(gallerist, dtoGallerist);
        dtoGallerist.setAddress(gallerist.getAddress());
        return dtoGallerist;
    }
}
