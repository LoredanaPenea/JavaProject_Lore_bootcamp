package tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.MultipleWindowsPage;
import pages.NewWindowPage;

public class MultipleWindowsTests extends BaseTest{
    @Test
    public void multipleWindowsTest(){
        MainPage mainPage = new MainPage(page);
        mainPage.multipleWindowsLink.click();

        MultipleWindowsPage windowsPage = new MultipleWindowsPage(page);
        PlaywrightAssertions.assertThat(windowsPage.heading).isVisible();

        Page popupPage = page.waitForPopup(() -> windowsPage.clickHereLink.click());

        NewWindowPage newWindowPage = new NewWindowPage(popupPage);

        Assertions.assertEquals("https://the-internet.herokuapp.com/windows/new",
                popupPage.url());
        PlaywrightAssertions.assertThat(newWindowPage.heading).isVisible();

        Page secondPopupPage = page.waitForPopup(() -> windowsPage.clickHereLink.click());

        NewWindowPage secondWindowPage = new NewWindowPage(secondPopupPage);
        Assertions.assertEquals("https://the-internet.herokuapp.com/windows/new",
                secondPopupPage.url());
        PlaywrightAssertions.assertThat(secondWindowPage.heading).isVisible();
    }
}
