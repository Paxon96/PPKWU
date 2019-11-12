package pl.weeia.paxon96.zadanie3.util;

import org.springframework.stereotype.Service;

@Service
public class Validator {

    public boolean validateMonth(Integer month){
        return month <= 12 && month > 0;
    }

    public boolean validateYear(Integer year){
        return year > 0;
    }

}
