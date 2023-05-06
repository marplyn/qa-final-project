package pages.mobile;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class CreditCardsBlogPage {
    private final By ARTICLES_CONTAINERS = By.cssSelector("[class=\"sc-pGacB eHzbCx\"]");
    private final By ARTICLES_TAGS = By.cssSelector("[class=\"sc-eCstlR SUwnL\"] [data-testid=\"link\"]");

    public CreditCardsBlogPage checkArticleTags() {
        for (SelenideElement selenideElement : $$(ARTICLES_CONTAINERS)) {
            ElementsCollection allTags = selenideElement.findAll(ARTICLES_TAGS);
            allTags.shouldHave(CollectionCondition.texts("Кредитные карты"));
        }
        return this;
    }
}
