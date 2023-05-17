package pages.desktop;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MortgagedPropertyOffersPage {
    private final By OFFER_TYPE = By.cssSelector(".advertisement__data .type p");

    @Step("Проверить тип предложения")
    public MortgagedPropertyOffersPage checkOfferType() {
        $(OFFER_TYPE).shouldHave(Condition.text("квартира"));
        return this;
    }
}
