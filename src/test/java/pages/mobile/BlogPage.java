package pages.mobile;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BlogPage {
    private final By CREDIT_CARDS_FILTER = By.xpath("//span/div[contains(text(),\"Кредитные карты\")]");
    public BlogPage filterArticles() {
        $(CREDIT_CARDS_FILTER).click();
        return this;
    }
}
