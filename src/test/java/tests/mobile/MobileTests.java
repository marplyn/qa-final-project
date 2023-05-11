package tests.mobile;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.mobile.*;

import static com.codeborne.selenide.Selenide.switchTo;

@DisplayName("Тестирование мобильной версии сайта")
public class MobileTests extends BaseMobileTest {
    // Тест-кейс 1.
    // 1. Открыть главную страницу
    // 2. В блоке "Блог" нажать кнопку "Читать"
    // 3. Поставить фильтр статей "Кредитные карты"
    // 4. Проверить, что отображены статьи только этой категории
    @Test
    @Description("Проверка фильтрации статей в блоге")
    public void blogFiltersTest() {
        HomePage homePage = new HomePage();
        BlogPage blogPage = new BlogPage();
        CreditCardsBlogPage creditCardsBlogPage = new CreditCardsBlogPage();

        homePage.openPage();
        homePage.clickAcceptRegionBtn();
        homePage.clickReadBlogBtn();

        blogPage.filterArticles();

        creditCardsBlogPage.checkArticleTags();
    }

    // Тест-кейс 2.
    // 1. Открыть главную страницу
    // 2. Перейти в раздел "Карты" в нижнем меню
    // 3. Выбрать карту Lite Мир и нажать на кнопку "Оформить карту"
    // 4.   a) Заполнить поле мобильного телефона коротким номером
    //      б) Оставить поле пустым
    // 5. Проверить, что появилась подсказка "Введите верный номер телефона"
    @ParameterizedTest
    @ValueSource(strings = {"", "95437"})
    @Description("Негативная проверка заполнения формы заказа виртуальной карты")
    public void mirLiteVirtualCardOrderNegativeTest(String phoneNumber) {
        HomePage homePage = new HomePage();
        CardsPage cardsPage = new CardsPage();
        MirLiteCardPage mirLiteCardPage = new MirLiteCardPage();

        homePage.openPage();
        homePage.clickAcceptRegionBtn();
        homePage.clickCardsNavbarBtn();

        cardsPage.clickMirLiteOrderCardBtn();

        mirLiteCardPage.fillPhoneField(phoneNumber);
        mirLiteCardPage.checkCorrectNumberHint();
    }

    // Тест-кейс 3.
    // 1. Открыть главную страницу
    // 2. Перейти в раздел "Кредиты" в нижнем меню
    // 3. Нажать кнопку "Оформить онлайн" Рефинансирования
    // 4. В форме заполнения заявки нажать на ссылку "согласием на обработку данных посетителя сайта"
    // 5. Проверить, что на открывшейся странице заголовок содержит "обработку данных посетителя сайта"
    @Test
    @Description("Проверка страницы согласия на обработку данных посетителя сайта")
    public void consentToPersonalDataProcessingTest() {
        HomePage homePage = new HomePage();
        LoansPage loansPage = new LoansPage();
        RefinancingPage refinancingPage = new RefinancingPage();
        ConsentToPersonalDataPage consentToPersonalDataPage = new ConsentToPersonalDataPage();

        homePage.openPage();
        homePage.clickAcceptRegionBtn();
        homePage.clickLoansNavbarBtn();

        loansPage.clickMakeRefinanceBtn();

        refinancingPage.clickConsentToPersonalDataLink();
        switchTo().window(1);

        consentToPersonalDataPage.checkPageTitle();
    }

    // Тест-кейс 4.
    // 1. Открыть главную страницу
    // 2. Нажать на иконку региона обслуживания
    // 3. В открывшемся модальном окне выбрать город Владивосток
    // 4. Нажать на кнопку "Еще" в нижнем меню
    // 5. Выбрать раздел "Офисы и банкоматы"
    // 6. Проверить, что в строке поиска на открывшейся странице введено название установленного города
    @Test
    @Description("Проверка отображения выбранного региона обсуживания")
    public void regionSettingTest() {
        HomePage homePage = new HomePage();
        OfficesAndATMsPage officesAndATMsPage = new OfficesAndATMsPage();

        homePage.openPage();
        homePage.clickAcceptRegionBtn();
        homePage.clickMapBtn();
        homePage.chooseCity();
        homePage.clickMoreNavbarBtn();
        homePage.clickOfficesAndATMs();

        officesAndATMsPage.checkSearchValue();
    }

    // Тест-кейс 5.
    // 1. Открыть главную страницу
    // 2. В баннере "Новости МТС Банка без задержки в Telegram" нажать на кнопку "Подписаться"
    // 3. Проверить, что на открывшейся странице отображается название чата
    @Test
    @Description("Проверка работы подписки на Telegram через баннер на главной странице")
    public void telegramBannerTest() {
        HomePage homePage = new HomePage();
        TelegramPage telegramPage = new TelegramPage();

        homePage.openPage();
        homePage.clickAcceptRegionBtn();
        homePage.clickTelegramBannerButton();
        switchTo().window(1);

        telegramPage.checkChatTitle();
    }
}
