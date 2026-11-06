package tests;

import org.junit.jupiter.api.Test;
import pages.EntryAdPage;
import pages.MainPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class EntryAdTests extends BaseTest {

    @Test
    void entryAdAppearsAndCanBeClosed() {
        MainPage mainPage = new MainPage(page);
        mainPage.entryAdLink.click();

        EntryAdPage entryAdPage = new EntryAdPage(page);
        assertThat(entryAdPage.modal).isVisible();
        assertThat(entryAdPage.modalTitle).hasText("This is a modal window");
        assertThat(entryAdPage.modalBody).isVisible();

        entryAdPage.closeBtn.click();
        assertThat(entryAdPage.modal).isHidden();
        assertThat(entryAdPage.restartAdLink).isVisible();
    }

    @Test
    void entryAdCanBeReEnabledAfterClosing() {
        MainPage mainPage = new MainPage(page);
        mainPage.entryAdLink.click();

        EntryAdPage entryAdPage = new EntryAdPage(page);
        assertThat(entryAdPage.modal).isVisible();

        entryAdPage.closeBtn.click();
        assertThat(entryAdPage.modal).isHidden();

        entryAdPage.restartAdLink.click();
        assertThat(entryAdPage.modal).isVisible();
        assertThat(entryAdPage.modalTitle).hasText("This is a modal window");

        entryAdPage.closeBtn.click();
        assertThat(entryAdPage.modal).isHidden();
    }
}
