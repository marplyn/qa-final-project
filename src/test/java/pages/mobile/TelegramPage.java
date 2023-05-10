package pages.mobile;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TelegramPage {
    private final By CHAT_NAME = By.cssSelector(".tgme_page_title span");

    public TelegramPage checkChatTitle() {
        $(CHAT_NAME).should(Condition.exist);
        return this;
    }
}
