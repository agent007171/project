package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.PhoneNumberService;

@Controller
public class DemoController {

    private PhoneNumberService phoneNumberService;

    @Autowired
    public DemoController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }

    @RequestMapping("/")
    public String displayMessage() {
        return "index.html";
    }

    @PostMapping("/submitPhoneNumber")
    @ResponseBody
    public ResponseEntity<?> submitPhoneNumber(@RequestParam String phoneNumber) {
        try {
            phoneNumberService.savePhoneNumber(phoneNumber);
            return ResponseEntity.ok("success");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
