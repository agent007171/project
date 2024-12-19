package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.PhoneNumber;
import com.example.demo.repository.PhoneNumberRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PhoneNumberRepositoryTest {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Test
    public void testSavePhoneNumber() {
        PhoneNumber phoneNumber = new PhoneNumber("+1234567890");
        PhoneNumber savedPhoneNumber = phoneNumberRepository.save(phoneNumber);

        assertThat(savedPhoneNumber).isNotNull();
        assertThat(savedPhoneNumber.getId()).isNotNull();
        assertThat(savedPhoneNumber.getNumber()).isEqualTo("+1234567890");
    }
}