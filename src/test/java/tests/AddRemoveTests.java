package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AddRemoveElementsPage;
import pages.MainPage;

public class AddRemoveTests extends BaseTest{
    @Test
    void addRemoveElements(){
        MainPage mainPage = new MainPage(page);
        mainPage.addRemoveElements.click();

        AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage(page);
        addRemoveElementsPage.addElementBtn.click();
        Assertions.assertTrue(addRemoveElementsPage.deleteBtn.isVisible(), "test failed");
    }


}
