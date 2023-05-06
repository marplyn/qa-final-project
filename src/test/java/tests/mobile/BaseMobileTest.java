package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Isolated;

public class BaseMobileTest {
    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.pageLoadStrategy = "eager";
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
    }

    @AfterEach
    public void cleanConfiguration() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        System.clearProperty("chromeoptions.mobileEmulation");
    }

    @AfterEach
    public void turnDown() {
        Selenide.closeWebDriver();
    }
}
