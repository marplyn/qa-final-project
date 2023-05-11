package pages.desktop;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ArticlePage {
    private final By ARTICLE_TITLE = By.cssSelector("h1[class*=\"styled__SmartText\"]");

    @Step("Проверить заголовок статьи")
    public ArticlePage checkArticleTitle(String expectedText) {
        $(ARTICLE_TITLE).shouldHave(Condition.text(expectedText));
        return this;
    }
}
