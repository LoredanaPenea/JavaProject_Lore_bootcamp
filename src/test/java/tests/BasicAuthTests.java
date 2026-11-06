package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BasicAuthPage;
import pages.MainPage;

public class BasicAuthTests  extends BaseTest{

    @Test
    void basicAuthTest(){

       BrowserContext authContext = browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin", "admin"));
       Page authPage = authContext.newPage();
       authPage.navigate("https://the-internet.herokuapp.com/");

        MainPage mainPage = new MainPage(authPage);
        mainPage.basicAuthLink.click();

        BasicAuthPage basicAuthPage = new BasicAuthPage(authPage);

      //  System.out.println("URL: " + authPage.url());
      //  System.out.println("Body: " + authPage.locator("body").innerText());

        Assertions.assertTrue(basicAuthPage.getBasicAuthHeading.isVisible());
        Assertions.assertTrue(basicAuthPage.basicAuthText.isVisible(), "test failed");

        authContext.close();
    }

    @Test
    void basicAuthWhenAuthenticationIsCancelled() {
        BrowserContext unauthenticatedContext = browser.newContext();
        Page unauthenticatedPage = unauthenticatedContext.newPage();
        unauthenticatedPage.navigate("https://the-internet.herokuapp.com/");

        MainPage mainPage = new MainPage(unauthenticatedPage);
        mainPage.basicAuthLink.click();

        BasicAuthPage basicAuthPage = new BasicAuthPage(unauthenticatedPage);

        // Cancel is clicked -- how to test it ??
        Assertions.assertTrue(basicAuthPage.locatorBody.innerText().contains("Not authorized"));

        unauthenticatedContext.close();
    }

}
