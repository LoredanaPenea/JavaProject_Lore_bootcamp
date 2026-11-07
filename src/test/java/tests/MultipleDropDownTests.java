package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.MultipleDropDownPage;

import java.util.List;

public class MultipleDropDownTests extends BaseTest{

    @Test
    void multipleOptionsCanBeSelected() {
        MainPage mainPage = new MainPage(page);
        mainPage.multipleSelectDropDownLink.click();

        MultipleDropDownPage dropdownPage = new MultipleDropDownPage(page);

        PlaywrightAssertions.assertThat(dropdownPage.heading).isVisible();
        Assertions.assertTrue(dropdownPage.options.count() >= 2);

        List<String> optionLabels = dropdownPage.options.allTextContents();
        String firstOption = optionLabels.get(0).trim();
        String secondOption = optionLabels.get(1).trim();
        String thirdOption = optionLabels.get(2).trim();
        String fourthOption = optionLabels.get(3).trim();

        dropdownPage.multiSelect.selectOption(new String[]{firstOption, secondOption});

        Assertions.assertEquals(List.of(firstOption, secondOption),
                dropdownPage.selectedOptions.allTextContents()
                        .stream().map(String::trim).toList());
    }
}
