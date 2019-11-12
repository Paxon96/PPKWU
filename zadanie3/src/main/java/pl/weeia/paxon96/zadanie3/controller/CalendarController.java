package pl.weeia.paxon96.zadanie3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.weeia.paxon96.zadanie3.resource.Message;
import pl.weeia.paxon96.zadanie3.service.CalendarService;
import pl.weeia.paxon96.zadanie3.util.Validator;

import java.io.IOException;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private Validator validator;
    @Autowired
    private CalendarService calendarService;

    @GetMapping
    public ResponseEntity<?> getCalendar(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month) throws IOException {

        if(month != null) {
            if (!validator.validateMonth(month))
                return new ResponseEntity<>(new Message("Wrong month value"), HttpStatus.BAD_REQUEST);
        }

        if(year != null) {
            if (!validator.validateYear(year))
                return new ResponseEntity<>(new Message("Wrong year value"), HttpStatus.BAD_REQUEST);
        }

        Resource fileSystemResource = new FileSystemResource(calendarService.getICalendar(month, year));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("text/calendar"))
                .body(fileSystemResource);
    }
}
