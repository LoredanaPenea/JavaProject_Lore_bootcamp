package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ToastsPage;

public class ToastsTests extends BaseTest{
    @Test
    public void toastsTest(){
        MainPage mainPage = new MainPage(page);
        mainPage.toastsLink.click();

        ToastsPage toastsPage = new ToastsPage(page);
        PlaywrightAssertions.assertThat(toastsPage.heading).isVisible();

        toastsPage.durationInput.fill("2000");
        PlaywrightAssertions.assertThat(toastsPage.toastsCount).containsText("Toasts shown: 0");

        toastsPage.successToastButton.click();
        toastsPage.errorToastButton.click();
        toastsPage.infoToastButton.click();

        PlaywrightAssertions.assertThat(toastsPage.toastsCount).containsText("Toasts shown: 3");

        PlaywrightAssertions.assertThat(toastsPage.successToast).isVisible();
        PlaywrightAssertions.assertThat(toastsPage.successToast).containsText("Saved successfully");
        PlaywrightAssertions.assertThat(toastsPage.errorToast).isVisible();
        PlaywrightAssertions.assertThat(toastsPage.errorToast).containsText("Something went wrong");
        PlaywrightAssertions.assertThat(toastsPage.infoToast).isVisible();
        PlaywrightAssertions.assertThat(toastsPage.infoToast).containsText("Here is some information");

    }
}
