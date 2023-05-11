package pages.desktop;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static tests.desktop.BaseDesktopTest.config;

public class HomePage {
    private final By MORTGAGED_PROPERTY = By.cssSelector("[href=\"/o-banke/realizacia-aktivov/\"]");
    private final By COMPLIANCE_AND_BUSINESS_ETHICS = By.cssSelector("[href=\"/o-banke/protivodeystvie-narusheniyam/\"]");
    private final By MORTGAGE = By.cssSelector("[href=\"/chastnim-licam/ipoteka/\"]");
    private final By OFFER_FORM_PHONE_NUM = By.cssSelector("input[type=tel]");
    private final By OFFER_FORM_PASSPORT_NUM = By.cssSelector("input[name=passportNumberWithSerial]");
    private final By OFFER_FORM_GET_LIMIT_BTN = By.cssSelector("button[class*=\"FormButton\"]");
    private final By OFFER_FORM_CONFIRMATION_FIELD = By.cssSelector("[data-testid=\"confirmationField\"]");
    private final By SECURITY_RULES = By.cssSelector("[href*=\"bezopasnost-ispolzovania\"]");

    @Step("Открыть главную страницу")
    public HomePage openPage() {
        open(config.baseUrl());
        return this;
    }

    @Step("Перейти по ссылке \"Реализуемое имущество\" в футере")
    public HomePage goToMortgagedPropertyPage() {
        $(MORTGAGED_PROPERTY).scrollIntoView(true);
        $(MORTGAGED_PROPERTY).click();
        return this;
    }

    @Step("Перейти по ссылке \"Комплаенс и деловая этика\" в футере")
    public HomePage goToComplianceAndBusinessEthicsPage() {
        $(COMPLIANCE_AND_BUSINESS_ETHICS).scrollIntoView(true);
        $(COMPLIANCE_AND_BUSINESS_ETHICS).click();
        return this;
    }

    @Step("Перейти во вкладку \"Ипотека\" в хедере")
    public HomePage goToMortgagePage() {
        $(MORTGAGE).click();
        return this;
    }

    @Step("Заполнить форму \"Узнайте ваше персональное предложение\"")
    public HomePage fillPersonalOfferForm(String phoneNumber, String passportNumber) {
        $(OFFER_FORM_PHONE_NUM).shouldBe(Condition.interactable);
        $(OFFER_FORM_PHONE_NUM).scrollIntoView(true);
        $(OFFER_FORM_PHONE_NUM).sendKeys(phoneNumber);
        $(OFFER_FORM_PASSPORT_NUM).sendKeys(passportNumber);
        $(OFFER_FORM_GET_LIMIT_BTN).click();
        return this;
    }

    @Step("Проверить наличие поля подтверждения номера телефона")
    public HomePage checkFormConfirmationField() {
        $(OFFER_FORM_CONFIRMATION_FIELD).shouldBe(Condition.visible);
        return this;
    }

    @Step("Перейти по ссылке \"Правила безопасности\" в футере")
    public HomePage goToSecurityRulesPage() {
        $(SECURITY_RULES).scrollIntoView(true);
        $(SECURITY_RULES).click();
        return this;
    }
}
