package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;
import pages.MainPage;

public class DropdownTests extends BaseTest {
    @Test
    public void dropdownTests() {
        MainPage mainPage = new MainPage(page);
        mainPage.dropdownLink.click();

        DropdownPage dropdownPage = new DropdownPage(page);

        Assertions.assertEquals("Please select an option",
                dropdownPage.dropdown.locator("option:checked").innerText().trim());

        dropdownPage.dropdown.selectOption("1");
        Assertions.assertEquals("1", dropdownPage.dropdown.inputValue());

        page.waitForTimeout(2000); // Pause so Option 1 is visible

        dropdownPage.dropdown.selectOption("2");
        Assertions.assertEquals("2", dropdownPage.dropdown.inputValue());
    }
}
