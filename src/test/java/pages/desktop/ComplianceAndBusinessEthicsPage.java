package pages.desktop;

import com.codeborne.pdftest.PDF;
import io.qameta.allure.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static com.codeborne.pdftest.PDF.containsText;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class ComplianceAndBusinessEthicsPage {

    @Step("Проверить содержание pdf-файла")
    public ComplianceAndBusinessEthicsPage checkPDFContents() throws Exception {
        File file = $("[href*=\"kodeks-ehtiki-pao-mts-bank.pdf\"]").download();
        assertThat(new PDF(file), containsText("Кодекс этики"));
        return this;
    }
}
