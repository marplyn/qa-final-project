package pages.desktop;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Selenide.$;

public class MortgagedPropertyOffersPage {
    private final By OFFER_TYPE = By.cssSelector(".advertisement__data .type p");

    @Step("Проверить тип предложения")
    public MortgagedPropertyOffersPage checkOfferType() {
        $(OFFER_TYPE).shouldBe(Condition.visible, Duration.of(4, ChronoUnit.SECONDS))
                .shouldHave(Condition.text("квартира"));
        return this;
    }
}
