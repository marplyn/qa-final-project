package pages.mobile;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CardsPage {
    private final By MIR_LITE_ORDER_CARD_BTN = By.cssSelector("[class*=\"MobileWrapper\"] [href*=\"mir-lite\"]");

    public CardsPage clickMirLiteOrderCardBtn() {
        $(MIR_LITE_ORDER_CARD_BTN).click();
        return this;
    }
}
