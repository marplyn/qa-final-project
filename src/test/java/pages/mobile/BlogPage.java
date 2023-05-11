package pages.mobile;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BlogPage {
    private final By CREDIT_CARDS_FILTER = By.xpath("//span/div[contains(text(),\"Кредитные карты\")]");

    @Step("Применить фильтр статей \"Кредитные карты\"")
    public BlogPage filterArticles() {
        $(CREDIT_CARDS_FILTER).click();
        return this;
    }
}
