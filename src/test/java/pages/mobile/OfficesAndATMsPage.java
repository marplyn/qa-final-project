package pages.mobile;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class OfficesAndATMsPage {
    private final By CITY_SEARCH_VALUE = By.cssSelector("[class*=\"MobileControlsBlock\"] input[type=\"text\"]");

    @Step("Проверить, установлен ли город в строке поиска")
    public OfficesAndATMsPage checkSearchValue() {
        Objects.requireNonNull($(CITY_SEARCH_VALUE).getAttribute("value")).equalsIgnoreCase("Владивосток");
        return this;
    }
}
