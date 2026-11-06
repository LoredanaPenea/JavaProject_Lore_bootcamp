package tests;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.JQueryUIMenuPage;
import pages.JQueryUIPage;
import pages.MainPage;

public class JQueryUIMenuTests extends BaseTest{
    @Test
    public void jQueryUIMenuDownloadPDFTest(){
        MainPage mainPage = new MainPage(page);
        mainPage.jqueryUiMenusLink.click();

        JQueryUIMenuPage jQueryUiMenuPage = new JQueryUIMenuPage(page);

        jQueryUiMenuPage.enabledItem.hover();
        PlaywrightAssertions.assertThat(jQueryUiMenuPage.downloadsItem).isVisible();

        jQueryUiMenuPage.downloadsItem.hover();
        PlaywrightAssertions.assertThat(jQueryUiMenuPage.pdfItem).isVisible();

        Download download = page.waitForDownload(() -> jQueryUiMenuPage.pdfItem.click());

        Assertions.assertTrue(download.suggestedFilename().toLowerCase().endsWith(".pdf"),
                "Expected the menu option to download a PDF file");

        jQueryUiMenuPage.enabledItem.hover();
        PlaywrightAssertions.assertThat(jQueryUiMenuPage.backToJQueryUiItem).isVisible();
        jQueryUiMenuPage.backToJQueryUiItem.click();
        Assertions.assertTrue(page.url().endsWith("/jqueryui"));
    }
    @Test
    public void jQueryUIMenuDownloadExcelTest(){
        MainPage mainPage = new MainPage(page);
        mainPage.jqueryUiMenusLink.click();

        JQueryUIMenuPage jQueryUIMenuPage = new JQueryUIMenuPage(page);

        jQueryUIMenuPage.enabledItem.hover();
        jQueryUIMenuPage.downloadsItem.hover();
        PlaywrightAssertions.assertThat(jQueryUIMenuPage.xlsItem).isVisible();

        Download download = page.waitForDownload(() -> jQueryUIMenuPage.xlsItem.click());

        Assertions.assertTrue(
                download.suggestedFilename().toLowerCase().endsWith(".xls"),
                "Expected the menu option to download an Excel file");

        jQueryUIMenuPage.enabledItem.hover();
        PlaywrightAssertions.assertThat(jQueryUIMenuPage.backToJQueryUiItem).isVisible();
        jQueryUIMenuPage.backToJQueryUiItem.click();
        Assertions.assertTrue(page.url().endsWith("/jqueryui"));
    }

    @Test
    void backToJqueryUiPageTests() {
        MainPage mainPage = new MainPage(page);
        mainPage.jqueryUiMenusLink.click();

        JQueryUIMenuPage jqueryUIMenuPage = new JQueryUIMenuPage(page);
        jqueryUIMenuPage.enabledItem.hover();
        jqueryUIMenuPage.backToJQueryUiItem.click();

        JQueryUIPage jQueryUIPage = new JQueryUIPage(page);

        PlaywrightAssertions.assertThat(jQueryUIPage.jqueryUiWebsiteLink).isVisible();
        PlaywrightAssertions.assertThat(jQueryUIPage.menuLink).isVisible();

        Assertions.assertTrue(jQueryUIPage.jqueryUiWebsiteLink.getAttribute("href").contains("jqueryui.com"));
        Assertions.assertTrue(jQueryUIPage.menuLink.getAttribute("href").endsWith("/jqueryui/menu"));

        jQueryUIPage.menuLink.click();
        Assertions.assertTrue(page.url().endsWith("/jqueryui/menu"));

        jqueryUIMenuPage.enabledItem.hover();
        jqueryUIMenuPage.backToJQueryUiItem.click();

        page.waitForNavigation(()-> jQueryUIPage.jqueryUiWebsiteLink.click());
        Assertions.assertTrue(page.url().contains("jqueryui.com"),
                "Expected the new page to open the jQuery UI website");

    }
}
