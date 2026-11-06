package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.KeyPressesPage;
import pages.MainPage;

public class KeyPressesTests extends BaseTest {
    @Test
    public void KeyPressesTest()
    {
        MainPage mainPage = new MainPage(page);
        mainPage.keyPressesLink.click();

        KeyPressesPage keyPressesPage = new KeyPressesPage(page);

        keyPressesPage.input.press("A");
        PlaywrightAssertions.assertThat(keyPressesPage.result).hasText("You entered: A");
        System.out.println("Result: " + keyPressesPage.result.innerText());

        keyPressesPage.input.press("Escape");
        PlaywrightAssertions.assertThat(keyPressesPage.result).hasText("You entered: ESCAPE");
        System.out.println("Result: " + keyPressesPage.result.innerText());

        keyPressesPage.input.press("Tab");
        PlaywrightAssertions.assertThat(keyPressesPage.result).hasText("You entered: TAB");
        System.out.println("Result: " + keyPressesPage.result.innerText());

        keyPressesPage.input.press("Alt");
        PlaywrightAssertions.assertThat(keyPressesPage.result).hasText("You entered: ALT");
        System.out.println("Result: " + keyPressesPage.result.innerText());

        keyPressesPage.input.click();
        page.keyboard().press("Enter");
        Assertions.assertTrue(page.url().endsWith("/key_presses?"),
                "Expected Enter to submit the form and reload the page");
    }
}
