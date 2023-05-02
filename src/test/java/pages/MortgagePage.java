package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MortgagePage {
    private final By IF_INCOME_IS_LOWER_LINK = By.xpath("//*[contains(text(),\"Если доход ниже\")]");
    private final By WHO_IS_CO_BORROWER_LINK = By.cssSelector("[href*=\"sozaemschik-po-ipoteke-eto-kto/ \"]");

    public MortgagePage openIfIncomeIsLowerModalWindow() {
        $(IF_INCOME_IS_LOWER_LINK).shouldBe(Condition.visible);
        $(IF_INCOME_IS_LOWER_LINK).click();
        return this;
    }

    public MortgagePage viewIfIncomeIsLowerModalWindow() {
        $(WHO_IS_CO_BORROWER_LINK).click();
        return this;
    }
}
