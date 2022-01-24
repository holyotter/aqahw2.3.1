package ru.netology.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateMeeting {

    static String dateInput(int days) {
        String inputDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return inputDate;
    }

    static String dateInputNext(int daysNext) {
        String inputDateNext = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return inputDateNext;
    }
}