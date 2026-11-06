package tests;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DynamicContentPage;
import pages.MainPage;

import java.util.List;

public class DynamicContentTests extends BaseTest {

    @Test
    void contentChangesAfterRefresh() {
        MainPage mainPage = new MainPage(page);
        mainPage.dynamicContentLink.click();

        DynamicContentPage dynamicContentPage = new DynamicContentPage(page);

        Assertions.assertEquals(3, dynamicContentPage.contentRows.count());

        String contentBeforeRefresh = dynamicContentPage.contentRows.allInnerTexts().toString();

        page.waitForTimeout(2000);
        page.reload();

        Assertions.assertEquals(3, dynamicContentPage.contentRows.count());
        String contentAfterRefresh = dynamicContentPage.contentRows.allInnerTexts().toString();

        Assertions.assertNotEquals(contentBeforeRefresh, contentAfterRefresh,
                "Expected the page content to change after refresh");
    }

    @Test
    void contentDoesNotChangeAfterRefresh() {
        //only first 2 rows are static
        MainPage mainPage = new MainPage(page);
        mainPage.dynamicContentLink.click();

        DynamicContentPage dynamicContentPage = new DynamicContentPage(page);
        dynamicContentPage.staticContentLink.click();

        Assertions.assertTrue(page.url().contains("?with_content=static"), "Expected the static-content URL");
        Assertions.assertEquals(3, dynamicContentPage.contentRows.count());
        String contentBeforeRefresh = dynamicContentPage.contentRows.allInnerTexts().toString();
        //List<String> before = getNormalizedRowTexts(dynamicContentPage.contentRows);

        page.waitForTimeout(2000);
        page.reload();

        Assertions.assertTrue(page.url().contains("with_content=static"));
        Assertions.assertEquals(3, dynamicContentPage.contentRows.count());
       String contentAfterRefresh = dynamicContentPage.contentRows.allInnerTexts().toString();
       // List<String> after = getNormalizedRowTexts(dynamicContentPage.contentRows);

       Assertions.assertEquals(contentBeforeRefresh, contentAfterRefresh, "Expected the page content to not change after refresh");
        //System.out.println("Before: " + before);
       // System.out.println("After:  " + after);
       // Assertions.assertEquals(before, after, "Static content should remain the same after refresh");

    }
    /*private List<String> getNormalizedRowTexts(Locator rows) {
        return rows.allInnerTexts().stream()
                .map(text -> text.replaceAll("\\s+", " ").trim())
                .toList();
    } */
}
