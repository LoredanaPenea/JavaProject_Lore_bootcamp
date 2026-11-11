package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pages.AdvancedIFramesPage;
import pages.MainPage;

public class AdvancediFramesTests extends BaseTest{
    @Test
    public void advancediFramesTest()
    {
        MainPage mainPage = new MainPage(page);
        mainPage.advancedIframesLink.click();

        AdvancedIFramesPage advancedIframesPage = new AdvancedIFramesPage(page);
        PlaywrightAssertions.assertThat(advancedIframesPage.heading).isVisible();

        PlaywrightAssertions.assertThat(advancedIframesPage.parentAccess)
                .hasText("The page can't read the sandboxed frame");

        PlaywrightAssertions.assertThat(advancedIframesPage.srcdocText)
                .hasText("Hello from srcdoc");

        advancedIframesPage.srcdocInput.fill("Text inside srcdoc");
        PlaywrightAssertions.assertThat(advancedIframesPage.srcdocInput)
                .hasValue("Text inside srcdoc");

        advancedIframesPage.sandboxedSendMessageButton.click();
        PlaywrightAssertions.assertThat(advancedIframesPage.messageLog)
                .containsText("Message from the sandbox");

        advancedIframesPage.shadowSendMessageButton.click();
        PlaywrightAssertions.assertThat(advancedIframesPage.messageLog)
                .containsText("Message from the shadow frame: hello");
    }
}
