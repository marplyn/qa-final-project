package pages.mobile;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ConsentToPersonalDataPage {
    private final By PAGE_TITLE = By.cssSelector("h1[class=\"title\"]");

    @Step("Проверить заголовок страницы")
    public ConsentToPersonalDataPage checkPageTitle() {
        $(PAGE_TITLE).should(Condition.text("обработку данных посетителя сайта"));
        return this;
    }
}
