package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HorizontalSliderPage;
import pages.MainPage;

public class HorizontalSliderTests extends BaseTest{
    @Test
    public void horizontalSliderTest(){
        MainPage mainPage = new MainPage(page);
        mainPage.horizontalSliderLink.click();

        HorizontalSliderPage sliderPage = new HorizontalSliderPage(page);

        Assertions.assertEquals("0", sliderPage.slider.inputValue());
        Assertions.assertEquals("0", sliderPage.sliderValue.innerText().trim());

        sliderPage.slider.press("ArrowRight");
        PlaywrightAssertions.assertThat(sliderPage.sliderValue).hasText("0.5");
        sliderPage.slider.press("ArrowRight");
        System.out.println("Slider value: "  + sliderPage.sliderValue.innerText());

        sliderPage.slider.press("ArrowLeft");
        PlaywrightAssertions.assertThat(sliderPage.sliderValue).hasText("0.5");
    }
}
