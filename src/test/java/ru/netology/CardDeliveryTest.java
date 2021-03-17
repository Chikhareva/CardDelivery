package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {
    @Test
    void shouldCheckFormDelivery(){
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Москва");
        SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy");
        Calendar today=Calendar.getInstance();
        today.add(Calendar.DAY_OF_MONTH,3);
        String dayVisit=(String)(format.format(today.getTime()));
        $("[data-test-id=date] input").sendKeys(Keys.CONTROL+"A"+Keys.DELETE);
        $("[data-test-id=date] input").setValue(dayVisit);
        $("[data-test-id=name] input").setValue("Петрова Катя");
        $("[data-test-id=phone] input").setValue("+79271547895");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $(withText("Успешно!")).waitUntil(Condition.visible,15000);
    }
}
