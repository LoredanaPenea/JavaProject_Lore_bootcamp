package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ForgotPasswordPage;
import pages.MainPage;

public class ForgotPasswordTests extends BaseTest{
    @Test
    void forgotPasswordFormCanBeSubmitted() {
        MainPage mainPage = new MainPage(page);
        mainPage.forgotPasswordLink.click();

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(page);

        Assertions.assertTrue(forgotPasswordPage.heading.isVisible());
        Assertions.assertTrue(forgotPasswordPage.emailInput.isVisible());
        Assertions.assertTrue(forgotPasswordPage.retrievePasswordBtn.isVisible());

        forgotPasswordPage.emailInput.fill("test@example.com");
        forgotPasswordPage.retrievePasswordBtn.click();

        // The form should navigate to the email confirmation page.
        Assertions.assertTrue(page.url().endsWith("/email_sent"));
        Assertions.assertTrue( forgotPasswordPage.confirmationMessage.isVisible(),
                "Expected the email confirmation message");
    }
}
