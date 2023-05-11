package pages.mobile;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TelegramPage {
    private final By CHAT_NAME = By.cssSelector(".tgme_page_title span");

    @Step("Проверить наличие и содержание названия Telegram-чата")
    public TelegramPage checkChatTitle() {
        $(CHAT_NAME).should(Condition.exist).shouldHave(Condition.text("МТС Банк"));
        return this;
    }
}
