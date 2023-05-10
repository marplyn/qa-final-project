package pages.mobile;

import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class OfficesAndATMsPage {
    private final By CITY_SEARCH_VALUE = By.cssSelector("[class*=\"MobileControlsBlock\"] input[type=\"text\"]");

    public OfficesAndATMsPage checkSearchValue() {
        Objects.requireNonNull($(CITY_SEARCH_VALUE).getAttribute("value")).equalsIgnoreCase("Владивосток");
        return this;
    }
}
