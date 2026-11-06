package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.JavaScriptAlertsPage;
import pages.MainPage;

public class JavaScriptAlertsTests extends BaseTest{
    @Test
    public void jsAlertsTestAccept()
    {
        MainPage mainPage = new MainPage(page);
        mainPage.javascriptAlertsLink.click();

        JavaScriptAlertsPage alertsPage = new JavaScriptAlertsPage(page);

        page.onceDialog(dialog ->
        {
            Assertions.assertEquals("I am a JS Alert", dialog.message());
            dialog.accept();
        });
        alertsPage.alertButton.click();
        PlaywrightAssertions.assertThat(alertsPage.resultText)
                .hasText("You successfully clicked an alert");
        page.waitForTimeout(2000);

        page.onceDialog(dialog ->
        {
            Assertions.assertEquals("I am a JS Confirm", dialog.message());
            dialog.accept();
        });
        alertsPage.confirmButton.click();
        PlaywrightAssertions.assertThat(alertsPage.resultText)
                .hasText("You clicked: Ok");
        page.waitForTimeout(2000);

        String promptText = "Hello from Playwright";
        page.onceDialog(dialog ->
        {
            Assertions.assertEquals("I am a JS prompt", dialog.message());
            dialog.accept(promptText);
        });
        alertsPage.promptButton.click();
        PlaywrightAssertions.assertThat(alertsPage.resultText)
                .hasText("You entered: " + promptText);
    }

    @Test
    void jsAlertsTestCancel() {
        MainPage mainPage = new MainPage(page);
        mainPage.javascriptAlertsLink.click();

        JavaScriptAlertsPage alertsPage = new JavaScriptAlertsPage(page);

        page.onceDialog(dialog ->
        {
            Assertions.assertEquals("I am a JS Confirm", dialog.message());
            dialog.dismiss();
        });
        alertsPage.confirmButton.click();
        PlaywrightAssertions.assertThat(alertsPage.resultText)
                .hasText("You clicked: Cancel");
        page.waitForTimeout(2000);

        page.onceDialog(dialog -> {
            Assertions.assertEquals("I am a JS prompt", dialog.message());
            dialog.dismiss();
        });
        alertsPage.promptButton.click();
        PlaywrightAssertions.assertThat(alertsPage.resultText)
                .hasText("You entered: null");
    }
}
