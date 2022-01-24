package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestOrderForm {

    public int days;

    @Test
    public void shouldAccepted() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Краснодар");
        $("[data-test-id=date] [placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] [placeholder='Дата встречи']").setValue(DateMeeting.dateInput(days));
        $("[data-test-id=name] [name='name']").setValue("Валерий Фокин-Хайкин");
        $("[data-test-id=phone] [name='phone']").setValue("+79296969292");
        $("[class=checkbox__box]").click();
        $(withText("Запланировать")).click();
        $(".notification__content").shouldBe(visible, Duration.ofSeconds(5))
                .shouldHave(exactText("Встреча успешно запланирована на " + DateMeeting.dateInput(days)));
    }

    @Test
    public void shouldReschedule() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Краснодар");
        $("[data-test-id=date] [placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] [placeholder='Дата встречи']").setValue(DateMeeting.dateInput(days));
        $("[data-test-id=name] [name='name']").setValue("Валерий Фокин-Хайкин");
        $("[data-test-id=phone] [name='phone']").setValue("+79296969292");
        $("[class=checkbox__box]").click();
        $(withText("Запланировать")).click();
        $(withText("Перепланировать?")).shouldBe(Condition.visible, Duration.ofSeconds(5));
        $$("[class=button__text]").find(exactText("Перепланировать")).click();
        $(".notification__content").shouldBe(visible, Duration.ofSeconds(5))
                .shouldHave(exactText("Встреча успешно запланирована на " + DateMeeting.dateInput(days)));
    }
}
