package tests;

import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DissappearingElementsPage;
import pages.MainPage;

public class DissappearingElementsTests extends BaseTest {
    @Test
     void disappearingElementsTests() {
        MainPage mainPage = new MainPage(page);
        mainPage.disappearingElementsLink.click();

        DissappearingElementsPage disappearingElementsPage = new DissappearingElementsPage(page);

        Assertions.assertTrue(disappearingElementsPage.headingDissapearingElem.isVisible());

        disappearingElementsPage.homeLink.click();
        Assertions.assertEquals("https://the-internet.herokuapp.com/", page.url());

        mainPage.disappearingElementsLink.click();
        disappearingElementsPage.aboutLink.click();
        Assertions.assertEquals("Not Found", page.locator("body").innerText());

        page.navigate("https://the-internet.herokuapp.com/");
        mainPage.disappearingElementsLink.click();
        disappearingElementsPage.contactUsLink.click();
        Assertions.assertEquals("Not Found", page.locator("body").innerText());

        page.navigate("https://the-internet.herokuapp.com/");
        mainPage.disappearingElementsLink.click();
        disappearingElementsPage.portfolioLink.click();
        Assertions.assertEquals("Not Found", page.locator("body").innerText());

        page.navigate("https://the-internet.herokuapp.com/");
        mainPage.disappearingElementsLink.click();
        if (disappearingElementsPage.galleryLink.count() == 0)
            System.out.println("Gallery link is not present on this load; skipping.");
        else {
            disappearingElementsPage.galleryLink.click();
            Assertions.assertEquals("Not Found", page.locator("body").innerText());
        }

    }

    @Test
    void galleryLinkDisappearAppearAfterRefresh() {
        MainPage mainPage = new MainPage(page);
        mainPage.disappearingElementsLink.click();

        DissappearingElementsPage disappearingPage = new DissappearingElementsPage(page);

        for (int refresh = 1; refresh <= 3; refresh++) {
            page.reload();
            page.waitForTimeout(2000);
            boolean galleryLinkIsVisible = disappearingPage.galleryLink.isVisible();
            System.out.println("Refresh " + refresh + ": Gallery link displayed = " + galleryLinkIsVisible);
        }
    }


}
