package pl.weeia.paxon96.zadanie1.entity;

import java.io.Serializable;

public class ValidatedString  implements Serializable {

    private String structure;

    public String getStructure() {
        return structure;
    }

    public ValidatedString(String stringToValidate) {
        this.structure = stringToValidate;
    }
}
