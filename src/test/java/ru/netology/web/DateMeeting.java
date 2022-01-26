package ru.netology.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateMeeting {

    static String dateInput(int days) {
        String inputDate = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return inputDate;
    }
}