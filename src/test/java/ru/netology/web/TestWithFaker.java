package ru.netology.web;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class TestWithFaker {

    static Faker faker = new Faker(new Locale("ru"));

    static String cityFake() {
        Random random = new Random();
        int rand = random.nextInt(12);
        String city[] = {"Владикавказ", "Казань", "Калининград", "Кемерово", "Ижевск", "Якутск", "Краснодар",
                "Красноярск", "Петрозаводск", "Махачкала", "Санкт-Петербург", "Сыктывкар", "Чебоксары"};
        return city[rand];
    }

    static String phoneFake() {
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    static String nameFake() {
        String name = faker.name().lastName();
        name = name + " " + faker.name().firstName();
        return name;
    }
}
