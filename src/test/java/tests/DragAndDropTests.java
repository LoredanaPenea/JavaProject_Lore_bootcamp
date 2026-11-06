package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DragAndDropPage;
import pages.MainPage;

public class DragAndDropTests extends BaseTest {
    @Test
    public void dragAndDropTests() {
        MainPage mainPage = new MainPage(page);
        mainPage.dragAndDropLink.click();

        DragAndDropPage dragAndDropPage = new DragAndDropPage(page);

        Assertions.assertEquals("A", dragAndDropPage.columnA.innerText().trim());
        Assertions.assertEquals("B", dragAndDropPage.columnB.innerText().trim());

        dragAndDropPage.columnA.dragTo(dragAndDropPage.columnB);

        Assertions.assertEquals("B", dragAndDropPage.columnA.innerText().trim());
        Assertions.assertEquals("A", dragAndDropPage.columnB.innerText().trim());
    }
}
