package pages.mobile;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoansPage {
    private final By MAKE_REFINANCE_BTN = By.cssSelector("[class*=\"sc-jSgvzq\"] [href*=\"/refinans/\"]");
    public LoansPage clickMakeRefinanceBtn() {
        $(MAKE_REFINANCE_BTN).click();
        return this;
    }
}
