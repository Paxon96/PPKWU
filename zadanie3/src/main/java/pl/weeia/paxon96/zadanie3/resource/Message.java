package pl.weeia.paxon96.zadanie3.resource;

import java.io.Serializable;

public class Message implements Serializable {

    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
