package pl.weeia.paxon96.zadanie3.service;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CalendarService {

    private final String PATH = "http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php?rok=%s&miesiac=%s&lang=1";

    public File getICalendar(Integer month, Integer year) throws IOException {
        LocalDate actualDate = LocalDate.now();
        if(month == null){
            month = actualDate.getMonthValue();
        }

        if(year == null){
            year = actualDate.getYear();
        }

        String url = String.format(PATH, year, month);
        File calendarFile = null;
        ICalendar iCalendar = new ICalendar();
        try {

            Document doc = Jsoup.connect(url).get();
            List<String> names = getEventNames(doc);
            List<Integer> days = getEventsDays(doc);

            Integer finalMonth = month;
            Integer finalYear = year;

            Map<Integer, String> dayEventMap = zipToMap(days, names);

            dayEventMap.forEach((day, event) -> {
                VEvent vEvent = new VEvent();
                vEvent.setSummary(event);
                Date eventDate = new GregorianCalendar(finalYear, finalMonth - 1, day).getTime();
                vEvent.setDateStart(eventDate);
                vEvent.setDateEnd(eventDate);
                iCalendar.addEvent(vEvent);
            });


            calendarFile = new File(year.toString()+ "_" + month.toString() + ".ics");
            Biweekly.write(iCalendar).go(calendarFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return calendarFile;
    }

    private static List<Integer> getEventsDays(Document doc){
        List<Integer> eventsDay = new ArrayList<>();
        doc.select("tr").select("td").select("a.active").forEach(element -> eventsDay.add(Integer.parseInt(element.text())));
        return eventsDay;
    }

    private static List<String> getEventNames(Document doc){
        List<String> eventsName = new ArrayList<>();
        doc.select("p").forEach(element -> eventsName.add(element.text()));
        return eventsName;
    }

    private static <K, V> Map<K, V> zipToMap(List<K> keys, List<V> values) {
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(keys::get, values::get));
    }

}
