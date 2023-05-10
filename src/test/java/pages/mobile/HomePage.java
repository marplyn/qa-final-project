package pages.mobile;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.desktop.BaseDesktopTest.config;

public class HomePage {
    private final By READ_BLOG_BTN = By.cssSelector("[href=\"https://www.mtsbank.ru/articles/\"]");
    private final By CARDS_NAVBAR_BTN = By.cssSelector("[href=\"/chastnim-licam/karti/\"]");
    private final By LOANS_NAVBAR_BTN = By.cssSelector("[class*=\"sc-eLgNKc\"] [href=\"/chastnim-licam/krediti/\"]");
    private final By MORE_NAVBAR_BTN = By.cssSelector("[data-testid*=\"main-page/mobileMenu/icon_more\"]");
    private final By ACCEPT_REGION_BTN = By.xpath("//div[contains(text(),\"Да, верно\")]");
    private final By MAP_BTN = By.cssSelector("[data-testid*=\"/ic-map2\"]");
    private final By CHANGE_REGION_MODAL = By.cssSelector("[id=\"change_region_modal\"]");
    private final By CITY_MODAL = By.xpath("//button[contains(text(),\"Владивосток\")]");
    private final By OFFICES_AND_ATMS_MENU_LINK = By.cssSelector(".ReactCollapse--content [href=\"/ofisi-i-bankomati/\"]");
    private final By TELEGRAM_BANNER_BTN = By.cssSelector("[data-testid=\"button\"][href*=\"t.me\"]");

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

    public HomePage clickLoansNavbarBtn() {
        $(LOANS_NAVBAR_BTN).click();
        return this;
    }

    public HomePage clickAcceptRegionBtn() {
        $(ACCEPT_REGION_BTN).click();
        return this;
    }

    public HomePage clickMapBtn() {
        $(MAP_BTN).click();
        return this;
    }

    public HomePage chooseCity() {
        $(CHANGE_REGION_MODAL)
                .shouldNotBe(Condition.empty)
                .shouldBe(Condition.visible);
        $(CITY_MODAL).click();
        return this;
    }

    public HomePage clickMoreNavbarBtn() {
        $(MORE_NAVBAR_BTN).click();
        return this;
    }

    public HomePage clickOfficesAndATMs() {
        $(OFFICES_AND_ATMS_MENU_LINK).click();
        return this;
    }

    public HomePage clickTelegramBannerButton() {
        $(TELEGRAM_BANNER_BTN).scrollIntoView(true);
        $(TELEGRAM_BANNER_BTN).click();
        return this;
    }
}
