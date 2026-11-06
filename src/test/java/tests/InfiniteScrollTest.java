package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.InfiniteScrollPage;
import pages.MainPage;

public class InfiniteScrollTest extends BaseTest{
    @Test
    public void infiniteScrollTest()
    {
        MainPage mainPage = new MainPage(page);
        mainPage.infiniteScrollLink.click();

        InfiniteScrollPage infiniteScrollPage = new InfiniteScrollPage(page);
        int initialCount = infiniteScrollPage.addedContent.count();

        page.evaluate("window.scrollTo(0, document.body.scrollHeight)");

        // Wait for another dynamically added section to appear.
        infiniteScrollPage.addedContent.nth(initialCount).waitFor();

        Assertions.assertTrue(infiniteScrollPage.addedContent.count() > initialCount,
                "Expected more content after scrolling");
    }
}
