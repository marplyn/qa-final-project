package pages.mobile;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RefinancingPage {
    private final By CONSENT_PERSONAL_DATA_PROC_LINK = By.xpath("//*[contains(text(),\"согласием на обработку\")]");

    @Step("Нажать на ссылку \"Согласие на обработку данных посетителя сайта\" под формой \"Персональная информация\"")
    public RefinancingPage clickConsentToPersonalDataLink() {
        $(CONSENT_PERSONAL_DATA_PROC_LINK).click();
        return this;
    }
}
