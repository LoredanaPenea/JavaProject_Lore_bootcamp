package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BrokenImagesPage;
import pages.MainPage;

public class BrokenImagesTests extends BaseTest{
    @Test
    void brokenImagesTest(){
        MainPage mainPage = new MainPage(page);
        mainPage.brokenImages.click();

        BrokenImagesPage brokenImagesPage = new BrokenImagesPage(page);

        Assertions.assertTrue(brokenImagesPage.brokenImagesHeading.isVisible());
        Assertions.assertEquals(3, brokenImagesPage.locatorImages.count());

        for (int i = 0; i < brokenImagesPage.locatorImages.count(); i++) {
            System.out.println(
                    "Image " + (i + 1) + " loaded: " + brokenImagesPage.isImageLoaded(i)
            );
        }
    }
}
