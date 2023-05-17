package tests.desktop;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.DisplayName;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pages.desktop.*;
import tests.desktop.BaseDesktopTest;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.switchTo;

@DisplayName("Тестирование десктопной версии сайта")
public class DesktopTests extends BaseDesktopTest {
    // Тест-кейс 1.
    // 1. Открыть главную страницу
    // 2. Проскроллить до футера и перейти в раздел "Реализуемое имущество"
    // 3. Перейти в раздел "Квартиры и комнаты" и проверить, что в карточке присутвует слово "квартира"
    @Test
    @Description("Проверка предложений реализуемого имущества")
    public void mortgagedPropertyTest() {
        HomePage homePage = new HomePage();
        MortgagedPropertyPage mortgagedPropertyPage = new MortgagedPropertyPage();
        MortgagedPropertyOffersPage mortgagedPropertyOffersPage = new MortgagedPropertyOffersPage();

        homePage.openPage();
        homePage.goToMortgagedPropertyPage();

        mortgagedPropertyPage.goToFlatsAndRoomsPage();

        mortgagedPropertyOffersPage.checkOfferType();
    }

    // Тест-кейс 2.
    // 1. Открыть главную страницу
    // 2. Проскроллить до футера и перейти в раздел "Комплаенс и деловая этика"
    // 3. Открыть PDF-документ "Кодекс этики"
    // 4. Проверить, что PDF-документ содержит текст "Кодекс этики"
    @Test
    @Description("Проверка содержания pdf-документа \"Кодекс этики\"")
    public void codeOfEthicsDocumentTest() throws Exception {
        HomePage homePage = new HomePage();
        ComplianceAndBusinessEthicsPage complianceAndBusinessEthicsPage = new ComplianceAndBusinessEthicsPage();

        homePage.openPage();
        homePage.goToComplianceAndBusinessEthicsPage();

        complianceAndBusinessEthicsPage.checkPDFContents();
    }

    // Тест-кейс 3.
    // 1. Открыть главную страницу
    // 2. Перейти во вкладку "Ипотека"
    // 3. В программе "Господдержка" нажать на "Если доход ниже"
    // 4. В модальном окне перейти по ссылке "Созаемщики по ипотеке: кто может быть и зачем нужны"
    // 5. Проверить, что название открывшейся статьи содержит слово "созаёмщик"
    @Test
    @Description("Проверка соответствия статьи ссылке в модальном окне")
    public void coBorrowerArticleTest() {
        HomePage homePage = new HomePage();
        MortgagePage mortgagePage = new MortgagePage();
        ArticlePage articlePage = new ArticlePage();

        homePage.openPage();
        homePage.goToMortgagePage();

        mortgagePage.openIfIncomeIsLowerModalWindow();
        mortgagePage.viewIfIncomeIsLowerModalWindow();
        switchTo().window(1);

        articlePage.checkArticleTitle("созаёмщик");
    }


    // Тест-кейс 4.
    // 1. Открыть главную страницу
    // 2. Заполнить форму "Узнайте ваше персональное предложение" рандомными валидными значениями
    // 3. Проверить появление поля подтверждения мобильного телефона
    @Test
    @Description("Позитивная проверка заполнения формы персонального предложения")
    public void personalOfferTest() {
        HomePage homePage = new HomePage();

        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("ru"), new RandomService());
        String randomPhoneNumber = fakeValuesService.numerify("9#########");
        String randomPassportNumber = fakeValuesService.numerify("##########");

        homePage.openPage();
        homePage.fillPersonalOfferForm(randomPhoneNumber, randomPassportNumber);
        homePage.checkFormConfirmationField();
    }

    // Тест-кейс 5.
    // 1. Открыть главную страницу
    // 2. Проскроллить до футера и перейти в раздел "Правила безопасности"
    // 3. Пройти тест "Обмани мошенника" со всеми верными утверждениями, проверяя результат каждого вопроса
    // 4. Проверить, что результат прохождения теста - 4/4
    @Test
    @Description("Проверка прохождения теста \"Обмани мошенника\"")
    public void personalSecurityQuizTest() {
        HomePage homePage = new HomePage();
        SecurityRulesPage securityRulesPage = new SecurityRulesPage();

        homePage.openPage();
        homePage.goToSecurityRulesPage();

        securityRulesPage.doSecurityQuizCorrect();
        securityRulesPage.checkQuizScore();
    }
}