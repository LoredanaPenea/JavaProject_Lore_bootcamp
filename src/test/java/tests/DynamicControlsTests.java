package tests;


import org.junit.jupiter.api.Test;
import pages.DynamicControlsPage;
import pages.MainPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DynamicControlsTests extends BaseTest {

    @Test
    void checkboxCanBeRemovedAndAdded() {
        MainPage mainPage = new MainPage(page);
        mainPage.dynamicControlsLink.click();

        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(page);

        assertThat(dynamicControlsPage.checkbox).isVisible();

        dynamicControlsPage.removeBtn.click();
        assertThat(dynamicControlsPage.checkbox).hasCount(0);
        assertThat(dynamicControlsPage.checkboxMessage).hasText("It's gone!");

        dynamicControlsPage.addBtn.click();
        assertThat(dynamicControlsPage.checkbox).isVisible();
        assertThat(dynamicControlsPage.checkboxMessage).hasText("It's back!");

        assertThat(dynamicControlsPage.input).isDisabled();

        dynamicControlsPage.enableBtn.click();
        assertThat(dynamicControlsPage.input).isEnabled();
        assertThat(dynamicControlsPage.inputMessage).hasText("It's enabled!");

        dynamicControlsPage.disableBtn.click();
        assertThat(dynamicControlsPage.input).isDisabled();
        assertThat(dynamicControlsPage.inputMessage).hasText("It's disabled!");
    }

    @Test
    void inputCanBeEnabledAndDisabled(){
        MainPage mainPage = new MainPage(page);
        mainPage.dynamicControlsLink.click();

        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(page);

        assertThat(dynamicControlsPage.input).isDisabled();

        dynamicControlsPage.enableBtn.click();
        assertThat(dynamicControlsPage.input).isEnabled();
        assertThat(dynamicControlsPage.inputMessage).hasText("It's enabled!");

        dynamicControlsPage.disableBtn.click();
        assertThat(dynamicControlsPage.input).isDisabled();
        assertThat(dynamicControlsPage.inputMessage).hasText("It's disabled!");
    }
}
