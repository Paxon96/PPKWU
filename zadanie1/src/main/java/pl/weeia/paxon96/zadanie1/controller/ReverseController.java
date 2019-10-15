package pl.weeia.paxon96.zadanie1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.weeia.paxon96.zadanie1.entity.ReversedString;
import pl.weeia.paxon96.zadanie1.utils.ReverseUtils;

@RestController
public class ReverseController {

    @Autowired
    private ReverseUtils reverseUtils;

    @GetMapping(value = "/rev", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReversedString> reverseString(@RequestParam String stringToReverse){
        return new ResponseEntity<>(new ReversedString(reverseUtils.reverseString(stringToReverse)), HttpStatus.OK);
    }
}
