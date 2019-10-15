package pl.weeia.paxon96.zadanie1.entity;

import java.io.Serializable;

public class ValidatedString  implements Serializable {

    private String string;

    public String getString() {
        return string;
    }

    public ValidatedString(String string) {
        this.string = string;
    }
}
