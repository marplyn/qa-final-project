package tests;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import io.qameta.allure.*;
import pages.HomePage;
import pages.MortgagedPropertyOffersPage;
import pages.MortgagedPropertyPage;

public class WebDesktopTests extends BaseTest {
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
}
