package pl.weeia.paxon96.zadanie3.resource;

public class Event {

    private String name;
    private String day;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Event(String name, String day) {
        this.name = name;
        this.day = day;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
