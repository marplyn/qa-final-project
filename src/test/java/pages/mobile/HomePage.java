package pages.mobile;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.desktop.BaseDesktopTest.config;

public class HomePage {
    private final By READ_BLOG_BTN = By.cssSelector("[href=\"https://www.mtsbank.ru/articles/\"]");
    private final By CARDS_NAVBAR_BTN = By.cssSelector("[href=\"/chastnim-licam/karti/\"]");
    private final By LOANS_NAVBAR_BTN = By.xpath("//span[contains(text(),\"Кредиты\")]/..");
    private final By MORE_NAVBAR_BTN = By.cssSelector("[data-testid*=\"main-page/mobileMenu/icon_more\"]");
    private final By ACCEPT_REGION_BTN = By.xpath("//div[contains(text(),\"Да, верно\")]");
    private final By MAP_BTN = By.cssSelector("[data-testid*=\"/ic-map2\"]");
    private final By CHANGE_REGION_MODAL = By.cssSelector("[id=\"change_region_modal\"]");
    private final By CITY_MODAL = By.xpath("//button[contains(text(),\"Владивосток\")]");
    private final By OFFICES_AND_ATMS_MENU_LINK = By.cssSelector(".ReactCollapse--content [href=\"/ofisi-i-bankomati/\"]");
    private final By TELEGRAM_BANNER_BTN = By.cssSelector("[data-testid=\"button\"][href*=\"t.me\"]");

    @Step("Открыть главную страницу")
    public HomePage openPage() {
        open(config.baseUrl());
        return this;
    }

    @Step("Нажать на кнопку \"Читать\" в баннере \"Блог\"")
    public HomePage clickReadBlogBtn() {
        $(READ_BLOG_BTN).scrollIntoView(true);
        $(READ_BLOG_BTN).click();
        return this;
    }

    @Step("Нажать на кнопку \"Карты\" на навигационной панели")
    public HomePage clickCardsNavbarBtn() {
        $(CARDS_NAVBAR_BTN).click();
        return this;
    }

    @Step("Нажать на кнопку \"Кредиты\" на навигационной панели")
    public HomePage clickLoansNavbarBtn() {
        $(LOANS_NAVBAR_BTN).click();
        return this;
    }

    @Step("Нажать на кнопку \"Да, верно\" на уведомлении о подтверждении региона")
    public HomePage clickAcceptRegionBtn() {
        if ($(ACCEPT_REGION_BTN).isDisplayed())
            $(ACCEPT_REGION_BTN).click();
        return this;
    }

    @Step("Нажать на иконку региона")
    public HomePage clickMapBtn() {
        $(MAP_BTN).click();
        return this;
    }

    @Step("Выбрать город в модальном окне региона обслуживания")
    public HomePage chooseCity() {
        $(CHANGE_REGION_MODAL)
                .shouldNotBe(Condition.empty)
                .shouldBe(Condition.visible);
        $(CITY_MODAL).click();
        return this;
    }

    @Step("Нажать на кнопку \"Еще\" на навигационной панели")
    public HomePage clickMoreNavbarBtn() {
        $(MORE_NAVBAR_BTN).click();
        return this;
    }

    @Step("Перейти по ссылке \"Офисы и банкоматы\" в меню")
    public HomePage clickOfficesAndATMs() {
        $(OFFICES_AND_ATMS_MENU_LINK).click();
        return this;
    }

    @Step("Нажать на кнопку \"Подписаться\" в баннере \"Новости МТС Банка в Telegram\"")
    public HomePage clickTelegramBannerButton() {
        $(TELEGRAM_BANNER_BTN).scrollIntoView(true);
        $(TELEGRAM_BANNER_BTN).click();
        return this;
    }
}
