package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.DemoController;
import com.example.demo.entity.PhoneNumber;
import com.example.demo.service.PhoneNumberService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class DemoControllerTest {

    @Mock
    private PhoneNumberService phoneNumberService;

    @InjectMocks
    private DemoController demoController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
    }

    @Test
    public void testSubmitPhoneNumber() throws Exception {
        String phoneNumber = "+1234567890";

        when(phoneNumberService.savePhoneNumber(phoneNumber)).thenReturn(new PhoneNumber(phoneNumber));

        mockMvc.perform(post("/submitPhoneNumber")
                .param("phoneNumber", phoneNumber)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(content().string("success"));

        verify(phoneNumberService, times(1)).savePhoneNumber(phoneNumber);
    }
}