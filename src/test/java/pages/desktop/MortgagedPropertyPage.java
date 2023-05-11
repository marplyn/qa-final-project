package pages.desktop;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MortgagedPropertyPage {
    private final By FLATS_AND_ROOMS_AMOUNT = By.cssSelector("[data-subcategory=\"vtorichnyy-rynok\"] .categories__link span");
    private final By FLATS_AND_ROOMS = By.cssSelector("[data-subcategory=\"vtorichnyy-rynok\"] .categories__link");

    public String flatsAndRoomsAmount;

    @Step("Получить количество предложений в категории \"Квартиры и комнаты\"")
    public MortgagedPropertyPage getFlatsAndRoomsAmount() {
        $(FLATS_AND_ROOMS).scrollIntoView(true);
        $(FLATS_AND_ROOMS_AMOUNT).should(Condition.exist, Condition.visible);
        flatsAndRoomsAmount = $(FLATS_AND_ROOMS_AMOUNT).getText();
        return this;
    }

    @Step("Перейти в категорию \"Квартиры и комнаты\"")
    public MortgagedPropertyPage goToFlatsAndRoomsPage() {
        $(FLATS_AND_ROOMS).click();
        return this;
    }
}
