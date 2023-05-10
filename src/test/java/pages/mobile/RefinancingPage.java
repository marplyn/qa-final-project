package pages.mobile;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RefinancingPage {
    private final By CONSENT_PERSONAL_DATA_PROC_LINK = By.xpath("//*[contains(text(),\"согласием на обработку\")]");

    public RefinancingPage clickConsentToPersonalDataLink() {
        $(CONSENT_PERSONAL_DATA_PROC_LINK).click();
        return this;
    }
}
