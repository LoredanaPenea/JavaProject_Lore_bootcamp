package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.InputsPage;
import pages.MainPage;

public class InputsTests extends BaseTest {
    @Test
    public void inputsTest()
    {
        MainPage mainPage = new MainPage(page);
        mainPage.inputsLink.click();

        InputsPage inputsPage = new InputsPage(page);

        inputsPage.numberInput.fill("42");
        Assertions.assertEquals("42", inputsPage.numberInput.inputValue());

        inputsPage.numberInput.press("ArrowUp");
        Assertions.assertEquals("43", inputsPage.numberInput.inputValue());

        inputsPage.numberInput.press("ArrowDown");
        Assertions.assertEquals("42", inputsPage.numberInput.inputValue());

        inputsPage.numberInput.clear();
        inputsPage.numberInput.click();
        inputsPage.numberInput.pressSequentially("abc");
        Assertions.assertEquals("", inputsPage.numberInput.inputValue(),
                "The number field should not contain letters");
    }
}
