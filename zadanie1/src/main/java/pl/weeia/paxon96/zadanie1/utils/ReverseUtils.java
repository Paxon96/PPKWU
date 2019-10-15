package pl.weeia.paxon96.zadanie1.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ReverseUtils {

    public String reverseString(String stringToReverse){
        return StringUtils.reverse(stringToReverse);
    }

}
