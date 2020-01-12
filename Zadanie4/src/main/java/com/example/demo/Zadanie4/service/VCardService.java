package com.example.demo.Zadanie4.service;

import com.example.demo.Zadanie4.util.Base64Coder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VCardService {

    @Autowired
    private Base64Coder base64Coder;

    public String createVCard(String vCardUrl){
        String[] parts = base64Coder.base64Decode(vCardUrl).split("\\n");
        String degree = "";
        String name = parts[0].split(" ")[0];
        String surname = parts[0].split(" ")[1];
        String organization = parts[1];
        if(parts.length == 3){
            degree = parts[2];
        }
        return "BEGIN:VCARD\n" +
                "VERSION:2.1\n" +
                "N:" + name + ";" + surname + "\n" +
                "FN:"  + degree + " "+ parts[0] + "\n" +
                "ORG:" + organization + "\n" +
                "END:VCARD";
    }

}
