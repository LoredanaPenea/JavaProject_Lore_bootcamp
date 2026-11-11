package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.BoundingBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.Arrays;
import java.util.List;

public class ShiftingContentTests extends BaseTest{
    @Test
    public void shiftingContentMenuTests()
    {
        MainPage mainPage = new MainPage(page);
        mainPage.shiftingContentLink.click();

        ShiftingContentPage shiftingPage = new ShiftingContentPage(page);
        shiftingPage.menuExampleLink.click();
        Assertions.assertTrue(page.url().endsWith("/shifting_content/menu"));

        BoundingBox positionBeforeRefresh = shiftingPage.shiftedMenuLink.boundingBox();
        page.reload();
        BoundingBox positionAfterRefresh = shiftingPage.shiftedMenuLink.boundingBox();

        Assertions.assertNotEquals(positionBeforeRefresh.x, positionAfterRefresh.x);

        ShiftingContentMenuPage menuPage = new ShiftingContentMenuPage(page);
        menuPage.pixelShift100Link.click();
        Assertions.assertTrue(page.url().endsWith("/shifting_content/menu?pixel_shift=100"));
    }

    @Test
    void imageShiftsTests() {
        MainPage mainPage = new MainPage(page);
        mainPage.shiftingContentLink.click();

        ShiftingContentPage shiftingPage = new ShiftingContentPage(page);
        shiftingPage.imageExampleLink.click();
        Assertions.assertTrue(page.url().endsWith("/shifting_content/image"));

        BoundingBox positionBeforeRefresh = shiftingPage.shiftedImage.boundingBox();
        page.reload();
        BoundingBox positionAfterRefresh = shiftingPage.shiftedImage.boundingBox();

        Assertions.assertNotEquals(positionBeforeRefresh.x, positionAfterRefresh.x);

        ShiftingContentImagePage imagePage = new ShiftingContentImagePage(page);
        PlaywrightAssertions.assertThat(imagePage.heading).isVisible();


        imagePage.randomModeLink.click();
        Assertions.assertEquals("https://the-internet.herokuapp.com/shifting_content/image?mode=random" , page.url());

        imagePage.pixelShift100Link.click();
        Assertions.assertTrue(page.url().endsWith("/shifting_content/image?pixel_shift=100"));

        imagePage.randomModeAndPixelShiftLink.click();
        Assertions.assertTrue(page.url().endsWith("/shifting_content/image?mode=random&pixel_shift=100"));

        imagePage.simpleImageLink.click();
        Assertions.assertTrue(page.url().endsWith("/shifting_content/image?image_type=simple"));

    }

    @Test
    void shiftingListContainsItsStaticRecord() {
        MainPage mainPage = new MainPage(page);
        mainPage.shiftingContentLink.click();

        ShiftingContentPage shiftingPage = new ShiftingContentPage(page);
        shiftingPage.listExampleLink.click();

        ShiftingContentListPage listPage = new ShiftingContentListPage(page);

        String staticRecord = "Important Information You're Looking For";
        PlaywrightAssertions.assertThat(listPage.listContent).containsText(staticRecord);

        List<String> initialLines = Arrays.stream(listPage.listContent.innerText().split("\\R"))
                .map(String::trim)
                .filter(line -> !line.isEmpty()).toList();

        int initialPosition = initialLines.indexOf(staticRecord);
        Assertions.assertTrue(initialPosition >= 0, "Static record should be in the list");

        boolean positionChanged = false;

        for (int i = 0; i < 10 && !positionChanged; i++) {
            page.reload();
            List<String> currentLines = Arrays.stream(listPage.listContent.innerText().split("\\R"))
                    .map(String::trim)
                    .filter(line -> !line.isEmpty()).toList();

            int currentPosition = currentLines.indexOf(staticRecord);
            Assertions.assertTrue(currentPosition >= 0, "Static record should remain in the list");
            positionChanged = currentPosition != initialPosition;
        }

        Assertions.assertTrue(positionChanged, "Expected the static record to move after one or more reloads");

    }

}
