package tests;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.switchTo;

public class WebDesktopTests extends BaseTest {
    // Тест-кейс 1.
    // 1. Открыть главную страницу
    // 2. Проскроллить до футера и перейти в раздел "Реализуемое имущество"
    // 3. В разделе "Жилая недвижимость" посмотреть кол-во предложений у категории "Квартиры и комнаты"
    // 4. Перейти в раздел "Квартиры и комнаты" и проверить кол-во предложений
    @Test
    public void mortgagedPropertyTest() {
        HomePage homePage = new HomePage();
        MortgagedPropertyPage mortgagedPropertyPage = new MortgagedPropertyPage();
        MortgagedPropertyOffersPage mortgagedPropertyOffersPage = new MortgagedPropertyOffersPage();

        homePage.openPage();
        homePage.goToMortgagedPropertyPage();

        mortgagedPropertyPage.getFlatsAndRoomsAmount();
        String flatsAndRoomsAmount = mortgagedPropertyPage.flatsAndRoomsAmount;
        mortgagedPropertyPage.goToFlatsAndRoomsPage();

        mortgagedPropertyOffersPage.checkAmountOfOffers(flatsAndRoomsAmount);
    }

    // Тест-кейс 2.
    // 1. Открыть главную страницу
    // 2. Проскроллить до футера и перейти в раздел "Комплаенс и деловая этика"
    // 3. Открыть PDF-документ "Кодекс этики"
    // 4. Проверить, что PDF-документ содержит текст "Кодекс этики"
    @Test
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
    public void coBorrowerArticleTest() {
        HomePage homePage = new HomePage();
        MortgagePage mortgagePage = new MortgagePage();
        BlogPage blogPage = new BlogPage();

        homePage.openPage();
        homePage.goToMortgagePage();

        mortgagePage.openIfIncomeIsLowerModalWindow();
        mortgagePage.viewIfIncomeIsLowerModalWindow();
        switchTo().window(1);

        blogPage.checkArticleTitle("созаёмщик");
    }


    // Тест-кейс 4.
    // 1. Открыть главную страницу
    // 2. Заполнить форму "Узнайте ваше персональное предложение" рандомными валидными значениями
    // 3. Проверить появление поля подтверждения мобильного телефона
    @Test
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
    public void personalSecurityQuizTest() {
        HomePage homePage = new HomePage();
        SecurityRulesPage securityRulesPage = new SecurityRulesPage();

        homePage.openPage();
        homePage.goToSecurityRulesPage();

        securityRulesPage.doSecurityQuizCorrect();
        securityRulesPage.checkQuizScore();
    }
}