package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LargePage;
import pages.MainPage;

public class LargeTests extends BaseTest {
    @Test
    public void largeTests() {
        MainPage mainPage = new MainPage(page);
        mainPage.largeLink.click();

        LargePage largePage = new LargePage(page);
        PlaywrightAssertions.assertThat(largePage.heading).isVisible();
        PlaywrightAssertions.assertThat(largePage.noSiblingsHeading).isVisible();
        PlaywrightAssertions.assertThat(largePage.siblingsHeading).isVisible();

        // The deeply nested section contains text values.
        Assertions.assertEquals(1, largePage.lastSibling.count());
        Assertions.assertEquals("50.3", largePage.lastSibling.innerText());

        Assertions.assertEquals(50, largePage.tableRows.count());
        Assertions.assertEquals(2500, largePage.tableCells.count());
    }
}
