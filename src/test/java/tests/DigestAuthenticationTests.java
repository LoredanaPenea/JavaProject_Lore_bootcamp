package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DigestAuthenticationPage;
import pages.MainPage;

public class DigestAuthenticationTests extends BaseTest {

    @Test
     void digestAuthenticationTests() {
        BrowserContext authContext = browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin", "admin"));
        Page authPage = authContext.newPage();
        authPage.navigate("https://the-internet.herokuapp.com/");

        MainPage mainPage = new MainPage(authPage);
        mainPage.digestAuthenticationLink.click();

        DigestAuthenticationPage digestAuthenticationPage = new DigestAuthenticationPage(authPage);

        Assertions.assertTrue(digestAuthenticationPage.heading.isVisible());
        Assertions.assertTrue(digestAuthenticationPage.successMessage.isVisible());

        authContext.close();

    }

    @Test
    void digestAuthenticationIsCanceled() {
        BrowserContext unauthenticatedContext = browser.newContext();
        Page unauthenticatedPage = unauthenticatedContext.newPage();
        unauthenticatedPage.navigate("https://the-internet.herokuapp.com/");

        MainPage mainPage = new MainPage(unauthenticatedPage);
        mainPage.digestAuthenticationLink.click();

        DigestAuthenticationPage digestAuthPage = new DigestAuthenticationPage(unauthenticatedPage);
        //cancel  ??

    }

    @Test
    void digestAuthenticationWrongCredentials() {
        BrowserContext wrongAuthContext = browser.newContext(new Browser.NewContextOptions().setHttpCredentials("wrong", "wrong"));
        Page wrongAuthPage = wrongAuthContext.newPage();
        wrongAuthPage.navigate("https://the-internet.herokuapp.com/");

        MainPage mainPage = new MainPage(wrongAuthPage);
        mainPage.digestAuthenticationLink.click();

        DigestAuthenticationPage digestAuthenticationPage = new DigestAuthenticationPage(wrongAuthPage);

       // Assertions.assertTrue(digestAuthenticationPage.heading.isVisible());
        Assertions.assertFalse(digestAuthenticationPage.successMessage.isVisible());

        wrongAuthContext.close();

    }

}
