package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MortgagedPropertyPage {
    private final By FLATS_AND_ROOMS_AMOUNT = By.cssSelector("[data-subcategory=\"vtorichnyy-rynok\"] .categories__link span");
    private final By FLATS_AND_ROOMS = By.cssSelector("[data-subcategory=\"vtorichnyy-rynok\"] .categories__link");

    public String flatsAndRoomsAmount;

    public MortgagedPropertyPage getFlatsAndRoomsAmount() {
        $(FLATS_AND_ROOMS).scrollIntoView(true);
        $(FLATS_AND_ROOMS_AMOUNT).should(Condition.exist, Condition.visible);
        flatsAndRoomsAmount = $(FLATS_AND_ROOMS_AMOUNT).getText();
        return this;
    }

    public MortgagedPropertyPage goToFlatsAndRoomsPage() {
        $(FLATS_AND_ROOMS).click();
        return this;
    }
}
