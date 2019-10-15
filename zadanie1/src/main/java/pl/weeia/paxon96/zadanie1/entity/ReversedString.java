package pl.weeia.paxon96.zadanie1.entity;

import java.io.Serializable;

public class ReversedString implements Serializable {

    private String reversedString;

    public ReversedString(String reversedString) {
        this.reversedString = reversedString;
    }

    public String getReversedString() {
        return reversedString;
    }
}
