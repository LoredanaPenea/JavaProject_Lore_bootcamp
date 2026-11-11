package tests;

import org.junit.jupiter.api.Test;
import pages.FormAuthenticationPage;
import pages.MainPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FormAuthenticationTests extends BaseTest {

    @Test
    void userCanLogInAndLogOut() {
        MainPage mainPage = new MainPage(page);
        mainPage.formAuthenticationLink.click();

        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(page);
        assertThat(formAuthenticationPage.heading).isVisible();
        formAuthenticationPage.usernameInput.fill("tomsmith");
        formAuthenticationPage.passwordInput.fill("SuperSecretPassword!");
        formAuthenticationPage.loginBtn.click();

        //assertThat(page).hasURL(Pattern.compile(".*/secure$"));
        assertThat(formAuthenticationPage.secureAreaHeading).isVisible();
        assertThat(formAuthenticationPage.flashMessage).containsText("You logged into a secure area!");

        formAuthenticationPage.logoutLink.click();

        //assertThat(page).hasURL(Pattern.compile(".*/login$"));
        assertThat(formAuthenticationPage.heading).isVisible();
        assertThat(formAuthenticationPage.flashMessage).containsText("You logged out of the secure area!");
    }

    @Test
    void invalidUsernameIsRejected() {
        MainPage mainPage = new MainPage(page);
        mainPage.formAuthenticationLink.click();

        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(page);
        formAuthenticationPage.usernameInput.fill("invalid-user");
        formAuthenticationPage.passwordInput.fill("SuperSecretPassword!");
        formAuthenticationPage.loginBtn.click();

        assertThat(formAuthenticationPage.flashMessage).containsText("Your username is invalid!");
        assertThat(formAuthenticationPage.secureAreaHeading).hasCount(0);
    }

    @Test
    void invalidPasswordIsRejected() {
        MainPage mainPage = new MainPage(page);
        mainPage.formAuthenticationLink.click();

        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(page);
        formAuthenticationPage.usernameInput.fill("tomsmith");
        formAuthenticationPage.passwordInput.fill("wrong-password");
        formAuthenticationPage.loginBtn.click();

        assertThat(formAuthenticationPage.logoutLink).hasCount(0);

       // assertThat(page).hasURL(Pattern.compile(".*/login$"));
        assertThat(formAuthenticationPage.flashMessage).containsText("Your password is invalid!");
        assertThat(formAuthenticationPage.secureAreaHeading).hasCount(0);
    }

    @Test
    void emptyCredentialsAreRejected() {
        MainPage mainPage = new MainPage(page);
        mainPage.formAuthenticationLink.click();

        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(page);
        assertThat(formAuthenticationPage.usernameInput).hasValue("");
        assertThat(formAuthenticationPage.passwordInput).hasValue("");
        formAuthenticationPage.loginBtn.click();

        assertThat(formAuthenticationPage.flashMessage).containsText("Your username is invalid!");
        assertThat(formAuthenticationPage.secureAreaHeading).hasCount(0);
    }
}
