package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BrokenImagesPage;
import pages.CanvasPage;
import pages.MainPage;

import java.awt.*;

public class CanvasTests extends BaseTest {
    @Test
    void canvasTests() {
        MainPage mainPage = new MainPage(page);
        mainPage.canvasLink.click();

        CanvasPage canvasPage = new CanvasPage(page);

        Assertions.assertTrue(canvasPage.canvas.isVisible());
        String canvasBefore = canvasPage.getCanvasImageData();
        canvasPage.drawPointAndTypeText("Hello Canvas");
        String canvasAfter = canvasPage.getCanvasImageData();
        String textSubmitted = canvasPage.canvasLog.innerText().replaceFirst("^Submitted:\\s*", "");
        System.out.println("Text submitted to canvas: " + textSubmitted);

        Assertions.assertNotEquals(canvasBefore, canvasAfter,
                "The canvas should change after drawing and submitting text");
    }
}
