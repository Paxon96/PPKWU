package pl.weeia.paxon96.zadanie1.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReverseController {

    @GetMapping("/rev")
    public ResponseEntity<String> reverseString(@RequestParam String stringToReverse){
        return new ResponseEntity<>(StringUtils.reverse(stringToReverse), HttpStatus.OK);
    }
}
