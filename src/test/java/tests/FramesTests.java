package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.FramesPage;
import pages.MainPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FramesTests extends BaseTest {
    @Test
    void nestedFramesDisplayExpectedText() {
        MainPage mainPage = new MainPage(page);
        mainPage.framesLink.click();

        FramesPage framesPage = new FramesPage(page);
        framesPage.nestedFramesLink.click();

        // Frame names are available on the page even though they are nested.
        assertThat(framesPage.leftFrameBody).hasText("LEFT");
        assertThat(framesPage.middleFrameBody).hasText("MIDDLE");
        assertThat(framesPage.rightFrameBody).hasText("RIGHT");
        Assertions.assertEquals("BOTTOM", page.frame("frame-bottom").locator("body").innerText().trim());
    }

    @Test
    void iframeEditorTextCanBeChanged() {
        MainPage mainPage = new MainPage(page);
        mainPage.framesLink.click();

        FramesPage framesPage = new FramesPage(page);
        framesPage.iframeLink.click();

        PlaywrightAssertions.assertThat(framesPage.editorBody).isVisible();
        framesPage.editorBody.waitFor();

        framesPage.editorBody.fill("Text entered in the iframe editor");

        assertThat(framesPage.editorBody).hasText("Text entered in the iframe editor");

    }
}
