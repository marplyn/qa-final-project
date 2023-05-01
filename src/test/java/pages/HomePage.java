package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.config;

public class HomePage {
    private final By MORTGAGED_PROPERTY = By.cssSelector("[href=\"/o-banke/realizacia-aktivov/\"]");

    public HomePage openPage() {
        open(config.baseUrl());
        return this;
    }

    public HomePage goToMortgagedPropertyPage() {
        $(MORTGAGED_PROPERTY).scrollIntoView(true);
        $(MORTGAGED_PROPERTY).click();
        return this;
    }
}
