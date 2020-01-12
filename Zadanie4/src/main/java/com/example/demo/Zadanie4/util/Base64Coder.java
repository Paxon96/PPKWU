package com.example.demo.Zadanie4.util;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Base64Coder {

    public String base64Encode(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    public String base64Decode(String input) {
        return new String(Base64.getDecoder().decode(input));
    }
}
