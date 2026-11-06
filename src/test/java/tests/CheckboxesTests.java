package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CheckboxesPage;
import pages.MainPage;

public class CheckboxesTests extends BaseTest {
    @Test
    public void checkboxesTests() {
        MainPage mainPage = new MainPage(page);
        mainPage.checkboxeslink.click();

        CheckboxesPage checkboxesPage = new CheckboxesPage(page);

        Assertions.assertEquals(2, checkboxesPage.checkboxes.count());
        Assertions.assertTrue(checkboxesPage.checkbox2.isChecked());

        checkboxesPage.checkbox1.check();
        checkboxesPage.checkbox2.uncheck();

        Assertions.assertTrue(checkboxesPage.checkbox1.isChecked());
        Assertions.assertFalse(checkboxesPage.checkbox2.isChecked());
    }
}
