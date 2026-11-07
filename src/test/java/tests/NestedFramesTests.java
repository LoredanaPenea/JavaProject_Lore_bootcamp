package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.NestedFramesPage;

public class NestedFramesTests extends BaseTest{
    @Test
    public void nestedFramesTest()
    {
        MainPage mainPage = new MainPage(page);
        mainPage.nestedFramesLink.click();

        NestedFramesPage framesPage = new NestedFramesPage(page);

        PlaywrightAssertions.assertThat(framesPage.leftFrameBody).hasText("LEFT");
        PlaywrightAssertions.assertThat(framesPage.middleFrameBody).hasText("MIDDLE");
        PlaywrightAssertions.assertThat(framesPage.rightFrameBody).hasText("RIGHT");
        PlaywrightAssertions.assertThat(framesPage.bottomFrameBody).hasText("BOTTOM");
    }
}
