package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.PhoneNumber;
import com.example.demo.repository.PhoneNumberRepository;
import com.example.demo.service.PhoneNumberService;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PhoneNumberServiceTest {

    @Mock
    private PhoneNumberRepository phoneNumberRepository;

    @InjectMocks
    private PhoneNumberService phoneNumberService;

    @Test
    public void testSavePhoneNumber() {
        String phoneNumber = "+1234567890";
        PhoneNumber savedPhoneNumber = new PhoneNumber(phoneNumber);

        when(phoneNumberRepository.save(any(PhoneNumber.class))).thenReturn(savedPhoneNumber);

        PhoneNumber result = phoneNumberService.savePhoneNumber(phoneNumber);

        assertThat(result).isNotNull();
        assertThat(result.getNumber()).isEqualTo(phoneNumber);
        verify(phoneNumberRepository, times(1)).save(any(PhoneNumber.class));
    }
}