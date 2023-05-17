package pages.desktop;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MortgagedPropertyPage {
    private final By FLATS_AND_ROOMS = By.cssSelector("[data-subcategory=\"vtorichnyy-rynok\"] .categories__link");


    @Step("Перейти в категорию \"Квартиры и комнаты\"")
    public MortgagedPropertyPage goToFlatsAndRoomsPage() {
        $(FLATS_AND_ROOMS).click();
        return this;
    }
}
