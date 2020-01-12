package com.example.demo.Zadanie4.controller;

import com.example.demo.Zadanie4.service.EmployeesService;
import com.example.demo.Zadanie4.service.VCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class VCardController {

    @Autowired
    private EmployeesService employeesService;
    @Autowired
    private VCardService vCardService;

    @GetMapping
    public String indexPage(){
        return "index";
    }

    @GetMapping("/results")
    public String findEmployees(@RequestParam("searchingString") String searchingString, final Model model) throws IOException {
        model.addAttribute("employees", employeesService.getEmployees(searchingString));
        return "results";
    }

    @GetMapping("/vcard/{vCard}")
    public ResponseEntity<String> generateVCard(@PathVariable("vCard") String vCard) {
        return ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=\"VCARD.VCF\"")
                .header("Content-Type","text/x-vcard")
                .body(vCardService.createVCard(vCard));
    }

}
