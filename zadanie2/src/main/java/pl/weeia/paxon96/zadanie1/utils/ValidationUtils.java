package pl.weeia.paxon96.zadanie1.utils;

import org.springframework.stereotype.Service;

@Service
public class ValidationUtils {

    private static boolean isNumeric(String strVal) {
        return strVal.matches("-?\\d+(\\.\\d+)?");
    }

    private static boolean isAlphanumeric(String strVal) {
        return strVal.matches("[^a-zA-Z0-9]+");
    }

    private static boolean containNumbers(String strVal) {
        return strVal.matches(".*\\d.*");
    }

    private static boolean isUpperCase(String strVal){
        return strVal.equals(strVal.toUpperCase());
    }

    private static boolean isLowerCase(String strVal){
        return strVal.equals(strVal.toLowerCase());
    }

    private static boolean isMixedCase(String strVal){
        return strVal.matches("[a-zA-Z]+");
    }

    public String validateString(String stringToValidate){
        if(isNumeric(stringToValidate)){
            return  "Numeric";
        }else if(isAlphanumeric(stringToValidate)){
            return  "Alphanumeric";
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
