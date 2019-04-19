package ru.akhitev.kb.javafx.swing.controller_with_constructor.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeService {
    public String getFormattedTime() {
        return LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
    }
}
