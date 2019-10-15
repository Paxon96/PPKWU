package pl.weeia.paxon96.zadanie1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.weeia.paxon96.zadanie1.entity.ValidatedString;
import pl.weeia.paxon96.zadanie1.utils.ValidationUtils;

@RestController
public class ValidateController {

    @Autowired
    private ValidationUtils validationUtils;

    @GetMapping("/validate")
    public ResponseEntity<ValidatedString> validateGivenType(@RequestParam String stringToValidate) {
        return new ResponseEntity<>(new ValidatedString(validationUtils.validateString(stringToValidate)), HttpStatus.OK);
    }

}
