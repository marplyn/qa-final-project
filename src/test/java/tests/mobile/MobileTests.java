package tests.mobile;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.mobile.*;

public class MobileTests extends BaseMobileTest {
    // Тест-кейс 1.
    // 1. Открыть главную страницу
    // 2. В блоке "Блог" нажать кнопку "Читать"
    // 3. Поставить фильтр статей "Кредитные карты"
    // 4. Проверить, что отображены статьи только этой категории
    @Test
    public void blogFiltersTest() {
        HomePage homePage = new HomePage();
        BlogPage blogPage = new BlogPage();
        CreditCardsBlogPage creditCardsBlogPage = new CreditCardsBlogPage();

        homePage.openPage();
        homePage.clickReadBlogBtn();

        blogPage.filterArticles();

        creditCardsBlogPage.checkArticleTags();
    }
    // Тест-кейс 2.
    // Открыть главную страницу
    // Перейти в раздел "Карты" в нижнем меню
    // Выбрать карту Lite Мир и нажать на кнопку "Оформить карту"
    // a) Заполнить поле мобильного телефона коротким номером
    // б) Оставить поле пустым
    // Проверить, что появилась подсказка "Введите верный номер телефона"
    @ParameterizedTest
    @ValueSource(strings = {"", "95437"})
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
}
