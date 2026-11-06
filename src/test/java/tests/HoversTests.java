package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HoversPage;
import pages.MainPage;

public class HoversTests extends BaseTest {
    @Test
    public void hoversTest()
    {
        MainPage mainPage = new MainPage(page);
        mainPage.hoversLink.click();

        HoversPage hoversPage = new HoversPage(page);

        Assertions.assertEquals(3, hoversPage.figures.count());

        Locator[] figures = {
                hoversPage.firstFigure,
                hoversPage.secondFigure,
                hoversPage.thirdFigure
        };

        String[] expectedNames = {"name: user1", "name: user2", "name: user3"};

        for (int i = 0; i < figures.length; i++) {
            figures[i].locator("img").hover();

            Locator caption = figures[i].locator(".figcaption");
            PlaywrightAssertions.assertThat(caption).isVisible();
            PlaywrightAssertions.assertThat(caption).containsText(expectedNames[i]);
            PlaywrightAssertions.assertThat(caption.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().
                    setName("View profile").setExact(true))).isVisible();
        }
    }
}
