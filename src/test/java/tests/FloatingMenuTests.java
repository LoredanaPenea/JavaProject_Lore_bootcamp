package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.junit.jupiter.api.Test;
import pages.FloatingMenuPage;
import pages.MainPage;

import java.util.List;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloatingMenuTests extends BaseTest {

    @Test
    void menuRemainsInViewportAfterScrolling() {
        MainPage mainPage = new MainPage(page);
        mainPage.floatingMenuLink.click();

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(page);
        assertThat(floatingMenuPage.heading).isVisible();
        assertThat(floatingMenuPage.homeLink).isVisible();
        assertThat(floatingMenuPage.newsLink).isVisible();
        assertThat(floatingMenuPage.contactLink).isVisible();
        assertThat(floatingMenuPage.aboutLink).isVisible();
        assertThat(floatingMenuPage.menu).isInViewport(
                new LocatorAssertions.IsInViewportOptions().setRatio(1));

        for (double fraction : new double[]{0.5, 1.0, 0.0}) {
            scrollToFraction(fraction);
            assertThat(floatingMenuPage.menu).isInViewport(
                    new LocatorAssertions.IsInViewportOptions().setRatio(1));
        }
    }

    @Test
    void menuLinksUpdateUrlAfterScrolling() {
        MainPage mainPage = new MainPage(page);
        mainPage.floatingMenuLink.click();

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(page);
        List<Locator> links = List.of(floatingMenuPage.homeLink, floatingMenuPage.newsLink,
                floatingMenuPage.contactLink, floatingMenuPage.aboutLink);
        List<String> fragments = List.of("home", "news", "contact", "about");

        for (int index = 0; index < links.size(); index++) {
            scrollToFraction(1.0);
            assertThat(floatingMenuPage.menu).isInViewport(
                    new LocatorAssertions.IsInViewportOptions().setRatio(1));
            assertThat(links.get(index)).isInViewport(
                    new LocatorAssertions.IsInViewportOptions().setRatio(1));

            links.get(index).click();
            assertThat(page).hasURL(Pattern.compile(".*/floating_menu#" + fragments.get(index) + "$"));
        }
    }

    private void scrollToFraction(double fraction) {
        page.evaluate("fraction => window.scrollTo(0, (document.documentElement.scrollHeight - window.innerHeight) * fraction)", fraction);
        page.waitForFunction("fraction => Math.abs(window.scrollY - (document.documentElement.scrollHeight - window.innerHeight) * fraction) <= 1", fraction);
        if (fraction > 0) {
            assertTrue((Boolean) page.evaluate("window.scrollY > 0"), "Expected the page to scroll down");
        }
    }
}
