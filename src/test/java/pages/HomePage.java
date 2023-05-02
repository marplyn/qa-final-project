package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.config;

public class HomePage {
    private final By MORTGAGED_PROPERTY = By.cssSelector("[href=\"/o-banke/realizacia-aktivov/\"]");
    private final By COMPLIANCE_AND_BUSINESS_ETHICS = By.cssSelector("[href=\"/o-banke/protivodeystvie-narusheniyam/\"]");
    private final By MORTGAGE = By.cssSelector("[href=\"/chastnim-licam/ipoteka/\"]");

    public HomePage openPage() {
        open(config.baseUrl());
        return this;
    }

    public HomePage goToMortgagedPropertyPage() {
        $(MORTGAGED_PROPERTY).scrollIntoView(true);
        $(MORTGAGED_PROPERTY).click();
        return this;
    }

    public HomePage goToComplianceAndBusinessEthicsPage() {
        $(COMPLIANCE_AND_BUSINESS_ETHICS).scrollIntoView(true);
        $(COMPLIANCE_AND_BUSINESS_ETHICS).click();
        return this;
    }

    public HomePage goToMortgagePage() {
        $(MORTGAGE).click();
        return this;
    }
}
