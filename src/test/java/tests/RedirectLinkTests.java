package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ReadonlyInputsPage;
import pages.RedirectLinkPage;
import pages.StatusCodesPage;

public class RedirectLinkTests extends BaseTest{
    @Test
    public void redirectLinkTest(){
        MainPage mainPage = new MainPage(page);
        mainPage.redirectLink.click();

        RedirectLinkPage redirectLinkPage = new RedirectLinkPage(page);
        PlaywrightAssertions.assertThat(redirectLinkPage.heading).isVisible();
        page.waitForNavigation(() -> redirectLinkPage.triggerRedirectLink.click());

        Assertions.assertTrue(page.url().endsWith("/status_codes"));
        StatusCodesPage statusCodesPage = new StatusCodesPage(page);
        PlaywrightAssertions.assertThat(statusCodesPage.heading).isVisible();

        String[] codes = {"200", "301", "404", "500"};
        Locator[] links = {
                statusCodesPage.code200Link,
                statusCodesPage.code301Link,
                statusCodesPage.code404Link,
                statusCodesPage.code500Link
                };

        for (int i = 0; i < codes.length; i++) {
            String code = codes[i];
            Locator link = links[i];

            Response response = page.waitForNavigation(() -> link.click());

            Assertions.assertNotNull(response);
            Assertions.assertEquals(Integer.parseInt(code), response.status());
            Assertions.assertTrue(page.url().endsWith("/status_codes/" + code));

            Locator resultMessage = page.locator("#content .example p").first();
            PlaywrightAssertions.assertThat(resultMessage).containsText(
                    "This page returned a " + code + " status code.");

            Locator backToStatusCodesLink = page.locator("#content .example p a[href='/status_codes']");
            backToStatusCodesLink.click();
            Assertions.assertTrue(page.url().endsWith("/status_codes"));

        }
        page.waitForNavigation(() -> statusCodesPage.hereLink.click());
        System.out.println("Current URL: " + page.url());
        Assertions.assertTrue(page.url().contains("www.iana.org/assignments/http-status-codes"));

        /*
        String code200 = statusCodesPage.code200Link.innerText();
        Response response = page.waitForNavigation(() -> statusCodesPage.code200Link.click());

        Assertions.assertNotNull(response);
        Assertions.assertEquals(Integer.parseInt(code200), response.status());
        Assertions.assertTrue(page.url().endsWith("/status_codes/" + code200));

        Locator resultMessage = page.locator("#content .example p").first();
        PlaywrightAssertions.assertThat(resultMessage).containsText(
                "This page returned a " + code200 + " status code.");
        Locator backToStatusCodesLink = page.locator("#content .example p a[href='/status_codes']");
        backToStatusCodesLink.click();
        Assertions.assertTrue(page.url().endsWith("/status_codes"));
         */
    }
}
