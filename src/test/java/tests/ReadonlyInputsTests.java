package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ReadonlyInputsPage;

public class ReadonlyInputsTests extends BaseTest{
    @Test
    public void readonlyInputsTest(){
        MainPage mainPage = new MainPage(page);
        mainPage.readonlyInputsLink.click();

        ReadonlyInputsPage readOnlyPage = new ReadonlyInputsPage(page);

        PlaywrightAssertions.assertThat(readOnlyPage.readOnlyCheckbox).not().isChecked();
        PlaywrightAssertions.assertThat(readOnlyPage.toggleTextInput).isEditable();
        PlaywrightAssertions.assertThat(readOnlyPage.toggleTextInput).hasValue("I am editable");

        readOnlyPage.readOnlyCheckbox.check();
        PlaywrightAssertions.assertThat(readOnlyPage.toggleTextInput).not().isEditable();
        PlaywrightAssertions.assertThat(readOnlyPage.toggleTextInput).hasValue("You cannot change me");

        PlaywrightAssertions.assertThat(readOnlyPage.alwaysReadOnlyInput).not().isEditable();
        PlaywrightAssertions.assertThat(readOnlyPage.alwaysReadOnlyInput).hasValue("You cannot change me");
        PlaywrightAssertions.assertThat(readOnlyPage.disabledInput).isDisabled();
        PlaywrightAssertions.assertThat(readOnlyPage.disabledInput).hasValue("I am disabled");

        readOnlyPage.readOnlyCheckbox.uncheck();
        PlaywrightAssertions.assertThat(readOnlyPage.toggleTextInput).isEditable();
        PlaywrightAssertions.assertThat(readOnlyPage.toggleTextInput).hasValue("I am editable");
    }
}
