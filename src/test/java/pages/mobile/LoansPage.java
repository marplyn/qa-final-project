package pages.mobile;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoansPage {
    private final By MAKE_REFINANCE_BTN = By.cssSelector("[type=\"base\"] [data-testid=\"button\"][href*=\"/refinans/\"]");

    @Step("Нажать на кнопку \"Оформить онлайн\" в блоке \"Рефинансирование\"")
    public LoansPage clickMakeRefinanceBtn() {
        $(MAKE_REFINANCE_BTN).click();
        return this;
    }
}
