package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pages.AutocompletePage;
import pages.MainPage;

public class AutocompleteTests extends BaseTest{
    @Test
     void testAutocomplete(){
        MainPage mainPage = new MainPage(page);
        mainPage.autocompleteLink.click();

        AutocompletePage autocompletePage = new AutocompletePage(page);
        PlaywrightAssertions.assertThat(autocompletePage.heading).isVisible();

        autocompletePage.fruitInput.fill("Ap");
        PlaywrightAssertions.assertThat(autocompletePage.appleSuggestion).isVisible();
        PlaywrightAssertions.assertThat(autocompletePage.status).hasText("2 suggestions");
        autocompletePage.appleSuggestion.click();

        PlaywrightAssertions.assertThat(autocompletePage.fruitInput).hasValue("Apple");
        PlaywrightAssertions.assertThat(autocompletePage.selectedText).hasText("You selected: Apple");
        PlaywrightAssertions.assertThat(autocompletePage.suggestions).isHidden();

        autocompletePage.fruitInput.fill("c");
        PlaywrightAssertions.assertThat(autocompletePage.suggestionOptions).hasCount(4);
        PlaywrightAssertions.assertThat(autocompletePage.suggestionOptions.nth(1)).hasText("Cherry");
        autocompletePage.suggestionOptions.nth(1).click();

        PlaywrightAssertions.assertThat(autocompletePage.fruitInput).hasValue("Cherry");
        PlaywrightAssertions.assertThat(autocompletePage.selectedText).hasText("You selected: Cherry");
        PlaywrightAssertions.assertThat(autocompletePage.suggestions).isHidden();
    }
}
