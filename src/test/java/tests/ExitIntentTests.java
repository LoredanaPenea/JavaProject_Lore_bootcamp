package tests;

import org.junit.jupiter.api.Test;
import pages.ExitIntentPage;
import pages.MainPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ExitIntentTests extends BaseTest {

    @Test
    void modalAppearsWhenMouseLeavesViewport() {
        MainPage mainPage = new MainPage(page);
        mainPage.exitIntentLink.click();

        ExitIntentPage exitIntentPage = new ExitIntentPage(page);
        assertThat(exitIntentPage.modal).isHidden();

        exitIntentPage.triggerExitIntent();
        assertThat(exitIntentPage.modal).isVisible();
        assertThat(exitIntentPage.modalTitle).hasText("This is a modal window");
        assertThat(exitIntentPage.modalBody).isVisible();

        exitIntentPage.closeBtn.click();
        assertThat(exitIntentPage.modal).isHidden();
    }

}
