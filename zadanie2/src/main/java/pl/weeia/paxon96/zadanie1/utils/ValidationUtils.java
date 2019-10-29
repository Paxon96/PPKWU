package pl.weeia.paxon96.zadanie1.utils;

import org.springframework.stereotype.Service;

@Service
public class ValidationUtils {

    private static boolean isNumeric(String stringToValidate) {
        return stringToValidate.matches("-?\\d+(\\.\\d+)?");
    }

    private static boolean isAlphanumeric(String stringToValidate) {
        return stringToValidate.matches("[a-zA-Z0-9]+");
    }

    private static boolean containNumbers(String stringToValidate) {
        return stringToValidate.matches(".*\\d.*");
    }

    private static boolean isUpperCase(String stringToValidate){
        return stringToValidate.equals(stringToValidate.toUpperCase());
    }

    private static boolean isLowerCase(String stringToValidate){
        return stringToValidate.equals(stringToValidate.toLowerCase());
    }

    private static boolean isMixedCase(String stringToValidate){
        return stringToValidate.matches("[a-zA-Z]+");
    }

    public String validateString(String stringToValidate){
        if(isNumeric(stringToValidate)){
            return  "Numeric";
        }else if(!isAlphanumeric(stringToValidate)){
            return  "Contains alphanumeric";
        }else if(containNumbers(stringToValidate)){
            return "Mixed letters and numbers";
        }else if(isUpperCase(stringToValidate)){
            return  "UpperCase";
        }else if(isLowerCase(stringToValidate)){
            return "LowerCase";
        }else if(isMixedCase(stringToValidate)){
            return "MixedCase";
        }

        return "String";
    }

}
