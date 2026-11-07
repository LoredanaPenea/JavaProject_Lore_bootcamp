package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.MainPage;
import pages.RadioButtonsPage;

public class RadioButtonsTests extends BaseTest {
    @Test
    public void radioButtonsTests() {
        MainPage mainPage = new MainPage(page);
        mainPage.radioButtonsLink.click();

        RadioButtonsPage radioPage = new RadioButtonsPage(page);

        PlaywrightAssertions.assertThat(radioPage.heading).isVisible();
        PlaywrightAssertions.assertThat(radioPage.blueRadio).isChecked();
        PlaywrightAssertions.assertThat(radioPage.redRadio).not().isChecked();
        PlaywrightAssertions.assertThat(radioPage.greenRadio).not().isChecked();
        PlaywrightAssertions.assertThat(radioPage.footballRadio).not().isChecked();
        PlaywrightAssertions.assertThat(radioPage.tennisRadio).not().isChecked();
        PlaywrightAssertions.assertThat(radioPage.hockeyRadio).isDisabled();

        radioPage.redRadio.check();
        radioPage.tennisRadio.check();

        PlaywrightAssertions.assertThat(radioPage.redRadio).isChecked();
        PlaywrightAssertions.assertThat(radioPage.blueRadio).not().isChecked();
        PlaywrightAssertions.assertThat(radioPage.greenRadio).not().isChecked();
        PlaywrightAssertions.assertThat(radioPage.tennisRadio).isChecked();
        PlaywrightAssertions.assertThat(radioPage.footballRadio).not().isChecked();
        PlaywrightAssertions.assertThat(radioPage.hockeyRadio).isDisabled();
        PlaywrightAssertions.assertThat(radioPage.result).hasText("Color: red, Sport: tennis");
        String redValue = radioPage.redRadio.getAttribute("value");
        String tennisValue = radioPage.tennisRadio.getAttribute("value");
        PlaywrightAssertions.assertThat(radioPage.result).hasText("Color: " + redValue + ", Sport: "+tennisValue);

    }
}
