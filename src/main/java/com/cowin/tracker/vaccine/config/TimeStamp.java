package com.cowin.tracker.vaccine.config;

import com.cowin.tracker.vaccine.util.Constants;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class TimeStamp {

    public String getTime() {
        return LocalDate.
                now()
                .format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT));
    }
}
