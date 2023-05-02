package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BlogPage {
    private final By ARTICLE_TITLE = By.cssSelector("h1[class*=\"styled__SmartText\"]");
    public BlogPage checkArticleTitle(String expectedText) {
        $(ARTICLE_TITLE).shouldHave(Condition.text(expectedText));
        return this;
    }
}
