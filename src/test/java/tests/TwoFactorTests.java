package tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.TwoFactorCodePage;
import pages.TwoFactorPage;
import pages.TwoFactorSecurePage;

public class TwoFactorTests extends BaseTest{
    @Test
    public void twoFactorTest(){
        MainPage mainPage = new MainPage(page);
        mainPage.twoFactorLink.click();

        TwoFactorPage twoFactorPage = new TwoFactorPage(page);
        twoFactorPage.usernameInput.fill("tomsmith");
        twoFactorPage.passwordInput.fill("SuperSecretPassword!");
        twoFactorPage.nextButton.click();

        Assertions.assertTrue(page.url().endsWith("/two_factor/code"));
        TwoFactorCodePage codePage = new TwoFactorCodePage(page);
        PlaywrightAssertions.assertThat(codePage.otpCode).isVisible();
        codePage.codeInput.fill(codePage.otpCode.innerText());
        codePage.verifyButton.click();

        Assertions.assertTrue(page.url().endsWith("/two_factor/secure"));
        PlaywrightAssertions.assertThat(codePage.successFlashMessage).isVisible();
        PlaywrightAssertions.assertThat(codePage.successFlashMessage)
                .containsText("You logged in with two-factor authentication!");

        TwoFactorSecurePage securePage = new TwoFactorSecurePage(page);
        PlaywrightAssertions.assertThat(securePage.welcomeHeading)
                .hasText("Welcome! You logged in with a password and a one-time code.");
        securePage.logoutLink.click();
        Assertions.assertTrue(page.url().endsWith("/two_factor"));

        PlaywrightAssertions.assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions()
                        .setName("Two-Factor Login").setExact(true))).isVisible();
        PlaywrightAssertions.assertThat(page.locator("#flash"))
                .containsText("You logged out of the secure area!");

    }

    @Test
    void invalidCredentialsAreRejected() {
        MainPage mainPage = new MainPage(page);
        mainPage.twoFactorLink.click();

        TwoFactorPage twoFactorPage = new TwoFactorPage(page);
        PlaywrightAssertions.assertThat(twoFactorPage.heading).isVisible();

        twoFactorPage.usernameInput.fill("wrongUsername");
        twoFactorPage.passwordInput.fill("wrongPassword");
        twoFactorPage.nextButton.click();

        PlaywrightAssertions.assertThat(page.getByText("Your username or password is invalid!", new Page.GetByTextOptions().setExact(true))).isVisible();
    }
}
