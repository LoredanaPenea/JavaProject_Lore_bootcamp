package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.WYSIWYGEditorPage;

public class WYSIWYGEditorTests extends BaseTest{
    @Test
    public void WYSIWYGEditorTextTests(){
        MainPage mainPage = new MainPage(page);
        mainPage.wysiwygEditorLink.click();

        WYSIWYGEditorPage wysiwygEditorPage = new WYSIWYGEditorPage(page);
        PlaywrightAssertions.assertThat(wysiwygEditorPage.heading).isVisible();
        PlaywrightAssertions.assertThat(wysiwygEditorPage.editorBody).isVisible();
        PlaywrightAssertions.assertThat(wysiwygEditorPage.editorBody).containsText("Your content goes here.");

        wysiwygEditorPage.editorBody.fill("Test Text entered with Playwright.");
        PlaywrightAssertions.assertThat(wysiwygEditorPage.editorBody).hasText("Test Text entered with Playwright.");


    }
}
