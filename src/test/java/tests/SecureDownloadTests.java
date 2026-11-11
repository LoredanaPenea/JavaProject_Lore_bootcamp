package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SecureDownloadPage;

public class SecureDownloadTests extends BaseTest{
    @Test
    public void secureDownloadTest(){

        BrowserContext authContext = browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin", "admin"));
        Page authPage = authContext.newPage();
        authPage.navigate("https://the-internet.herokuapp.com/");

            MainPage mainPage = new MainPage(authPage);
            mainPage.secureFileDownloadLink.click();

            SecureDownloadPage secureDownloadPage = new SecureDownloadPage(authPage);
            PlaywrightAssertions.assertThat(secureDownloadPage.heading).isVisible();
            PlaywrightAssertions.assertThat(secureDownloadPage.someFileLink).isVisible();

            Download download = authPage.waitForDownload(() -> secureDownloadPage.someFileLink.click());

            Assertions.assertEquals("some-file.txt", download.suggestedFilename());
            Assertions.assertNotNull(download.path(), "Expected the download to be saved");

            authContext.close();

    }
}
