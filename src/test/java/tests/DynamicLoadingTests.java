package tests;

import com.microsoft.playwright.assertions.LocatorAssertions;
import org.junit.jupiter.api.Test;
import pages.DynamicLoadingPage;
import pages.MainPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DynamicLoadingTests extends BaseTest {

    @Test
    void hiddenElementBecomesVisibleAfterLoading() {
        MainPage mainPage = new MainPage(page);
        mainPage.dynamicLoadingLink.click();

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(page);
        dynamicLoadingPage.example1Link.click();

        assertThat(dynamicLoadingPage.finishText).hasCount(1);
        assertThat(dynamicLoadingPage.finishText).isHidden();

        dynamicLoadingPage.startBtn.click();
        assertThat(dynamicLoadingPage.loading).isVisible();
        assertThat(dynamicLoadingPage.finishText).isVisible(
                new LocatorAssertions.IsVisibleOptions().setTimeout(10000));
        assertThat(dynamicLoadingPage.finishText).hasText("Hello World!");
        assertThat(dynamicLoadingPage.loading).isHidden();
        assertThat(dynamicLoadingPage.startBtn).isHidden();
    }

    @Test
    void elementIsRenderedAfterLoading() {
        MainPage mainPage = new MainPage(page);
        mainPage.dynamicLoadingLink.click();

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(page);
        dynamicLoadingPage.example2Link.click();

        assertThat(dynamicLoadingPage.finishText).hasCount(0);

        dynamicLoadingPage.startBtn.click();
        assertThat(dynamicLoadingPage.loading).isVisible();
        assertThat(dynamicLoadingPage.finishText).isVisible(
                new LocatorAssertions.IsVisibleOptions().setTimeout(10000));
        assertThat(dynamicLoadingPage.finishText).hasText("Hello World!");
        assertThat(dynamicLoadingPage.loading).isHidden();
        assertThat(dynamicLoadingPage.startBtn).isHidden();
    }
}
