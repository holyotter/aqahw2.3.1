package ru.netology.web;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class TestWithFaker {

    private static Faker faker;

    static void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

//    @Test
    void shouldGenerateData() {

    }
}
