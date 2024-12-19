package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PhoneNumber;
import com.example.demo.repository.PhoneNumberRepository;

@Service
public class PhoneNumberService {

    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    public PhoneNumberService(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }

    public PhoneNumber savePhoneNumber(String number) {
        if (!number.matches("\\d{8}")) {
            throw new IllegalArgumentException("Номер телефона должен состоять ровно из 8 цифр.");
        }
        PhoneNumber phoneNumber = new PhoneNumber(number);
        return phoneNumberRepository.save(phoneNumber);
    }
}
