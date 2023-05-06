package pages.mobile;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.desktop.BaseDesktopTest.config;

public class HomePage {
    private final By READ_BLOG_BTN = By.cssSelector("[href=\"https://www.mtsbank.ru/articles/\"]");
    private final By CARDS_NAVBAR_BTN = By.cssSelector("[href=\"/chastnim-licam/karti/\"]");
    private final By ACCEPT_REGION_BTN = By.xpath("//div[contains(text(),\"Да, верно\")]");

    public HomePage openPage() {
        open(config.baseUrl());
        return this;
    }

    public HomePage clickReadBlogBtn() {
        $(READ_BLOG_BTN).scrollIntoView(true);
        $(READ_BLOG_BTN).click();
        return this;
    }

    public HomePage clickCardsNavbarBtn() {
        $(CARDS_NAVBAR_BTN).click();
        return this;
    }

    public HomePage clickAcceptRegionBtn() {
        $(ACCEPT_REGION_BTN).click();
        return this;
    }
}
