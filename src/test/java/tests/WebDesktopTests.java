package tests;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import io.qameta.allure.*;
import pages.ComplianceAndBusinessEthicsPage;
import pages.HomePage;
import pages.MortgagedPropertyOffersPage;
import pages.MortgagedPropertyPage;

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
}