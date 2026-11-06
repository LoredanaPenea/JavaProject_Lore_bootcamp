package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LargeFormPage;
import pages.MainPage;

public class LargeFormTests extends BaseTest{
    @Test
    public void largeFormTestSubmit(){
        MainPage mainPage = new MainPage(page);
        mainPage.largeFormLink.click();

        LargeFormPage largeFormPage = new LargeFormPage(page);

        PlaywrightAssertions.assertThat(largeFormPage.heading).isVisible();

        largeFormPage.firstNameInput.fill("Alex");
        largeFormPage.lastNameInput.fill("Tester");
        largeFormPage.emailInput.fill("alex@example.com");
        largeFormPage.passwordInput.fill("TestPassword123");
        largeFormPage.nicknameInput.fill("TestNickname");

        largeFormPage.birthdayInput.fill("1990-01-15");
        largeFormPage.ageInput.fill("35");
        largeFormPage.countrySelect.selectOption("ar");
        largeFormPage.languagesSelect.selectOption(new String[]{"English", "Spanish"});
        String selectedLanguages = (String) largeFormPage.languagesSelect.evaluate(
                "select => Array.from(select.selectedOptions)"
                        + ".map(option => option.value).join(', ')");
        largeFormPage.aboutYouInput.fill("I am learning test automation.");

        PlaywrightAssertions.assertThat(largeFormPage.contactByEmail).isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.contactByPhone).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.doNotContact).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.testingInterest).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.automationInterest).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.devOpsInterest).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.experienceSlider).hasValue("5");
        PlaywrightAssertions.assertThat(largeFormPage.experienceValue).hasText("5");
        Assertions.assertEquals("#e2231a", largeFormPage.favoriteColorInput.inputValue());

        largeFormPage.contactByPhone.check();
        largeFormPage.automationInterest.check();
        largeFormPage.experienceSlider.press("ArrowRight");
        largeFormPage.experienceSlider.press("ArrowRight");
        largeFormPage.experienceSlider.press("ArrowRight");
        largeFormPage.experienceSlider.press("ArrowRight");
        largeFormPage.experienceSlider.press("ArrowRight");

        largeFormPage.termsCheckbox.check();
       //
        PlaywrightAssertions.assertThat(largeFormPage.firstNameInput).hasValue("Alex");
        PlaywrightAssertions.assertThat(largeFormPage.lastNameInput).hasValue("Tester");
        PlaywrightAssertions.assertThat(largeFormPage.emailInput).hasValue("alex@example.com");
        PlaywrightAssertions.assertThat(largeFormPage.nicknameInput).hasValue("TestNickname");

        PlaywrightAssertions.assertThat(largeFormPage.birthdayInput).hasValue("1990-01-15");
        PlaywrightAssertions.assertThat(largeFormPage.ageInput).hasValue("35");
        PlaywrightAssertions.assertThat(largeFormPage.countrySelect).hasValue("ar");
        Assertions.assertEquals("English, Spanish", selectedLanguages);
        PlaywrightAssertions.assertThat(largeFormPage.aboutYouInput)
                .hasValue("I am learning test automation.");

        PlaywrightAssertions.assertThat(largeFormPage.contactByPhone).isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.contactByEmail).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.doNotContact).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.automationInterest).isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.experienceSlider).hasValue("10");
        PlaywrightAssertions.assertThat(largeFormPage.experienceValue).hasText("10");

        PlaywrightAssertions.assertThat(largeFormPage.termsCheckbox).isChecked();

        largeFormPage.submitButton.click();
        PlaywrightAssertions.assertThat(largeFormPage.submittedHeading).isVisible();
        PlaywrightAssertions.assertThat(largeFormPage.fieldColumnHeader).hasText("Field");
        PlaywrightAssertions.assertThat(largeFormPage.valueColumnHeader).hasText("Value");

        assertSubmittedField(largeFormPage, "first_name", "Alex");
        assertSubmittedField(largeFormPage, "last_name", "Tester");
        assertSubmittedField(largeFormPage, "email", "alex@example.com");
        assertSubmittedField(largeFormPage, "password", "***************");
        assertSubmittedField(largeFormPage, "nickname", "TestNickname");

        assertSubmittedField(largeFormPage, "birthday", "1990-01-15");
        assertSubmittedField(largeFormPage, "age", "35");
        assertSubmittedField(largeFormPage,"country", "ar");
        assertSubmittedField(largeFormPage, "languages", selectedLanguages);
        assertSubmittedField(largeFormPage, "bio", "I am learning test automation.");

        assertSubmittedField(largeFormPage,"contact","phone");
        assertSubmittedField(largeFormPage,"interests", "automation");
        assertSubmittedField(largeFormPage,"experience", "10");
        assertSubmittedField(largeFormPage,"color", "#e2231a");

        assertSubmittedField(largeFormPage,"terms", "accepted");


    }

    private void assertSubmittedField(LargeFormPage formPage, String fieldName, String expectedValue) {
        Locator row = formPage.submittedValuesTable.locator("tbody tr")
                .filter(new Locator.FilterOptions().setHasText(fieldName));

        PlaywrightAssertions.assertThat(row.locator("td").nth(0)).hasText(fieldName);
        PlaywrightAssertions.assertThat(row.locator("td").nth(1)).hasText(expectedValue);
    }

@Test
    public void largeFormTestReset(){
        MainPage mainPage = new MainPage(page);
        mainPage.largeFormLink.click();

        LargeFormPage largeFormPage = new LargeFormPage(page);

        PlaywrightAssertions.assertThat(largeFormPage.heading).isVisible();

        largeFormPage.firstNameInput.fill("Alex");
        largeFormPage.lastNameInput.fill("Tester");
        largeFormPage.emailInput.fill("alex@example.com");
        largeFormPage.passwordInput.fill("TestPassword123");
        largeFormPage.nicknameInput.fill("TestNickname");

        largeFormPage.birthdayInput.fill("1990-01-15");
        largeFormPage.ageInput.fill("35");
        String initialCountry = largeFormPage.countrySelect.inputValue();
        String initialLanguages = (String) largeFormPage.languagesSelect.evaluate(
                "select => Array.from(select.selectedOptions)"
                        + ".map(option => option.value).join(',')");
        largeFormPage.languagesSelect.selectOption(new String[]{"English"});
        largeFormPage.aboutYouInput.fill("I am learning test automation.");

        PlaywrightAssertions.assertThat(largeFormPage.contactByEmail).isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.contactByPhone).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.doNotContact).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.testingInterest).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.automationInterest).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.devOpsInterest).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.experienceSlider).hasValue("5");
        PlaywrightAssertions.assertThat(largeFormPage.experienceValue).hasText("5");
        Assertions.assertEquals("#e2231a", largeFormPage.favoriteColorInput.inputValue());

        largeFormPage.contactByPhone.check();
        largeFormPage.automationInterest.check();
        largeFormPage.experienceSlider.press("ArrowRight");
        largeFormPage.experienceSlider.press("ArrowRight");
        largeFormPage.experienceSlider.press("ArrowRight");
        largeFormPage.experienceSlider.press("ArrowRight");
        largeFormPage.experienceSlider.press("ArrowRight");

        largeFormPage.termsCheckbox.check();

        PlaywrightAssertions.assertThat(largeFormPage.firstNameInput).hasValue("Alex");
        PlaywrightAssertions.assertThat(largeFormPage.lastNameInput).hasValue("Tester");
        PlaywrightAssertions.assertThat(largeFormPage.emailInput).hasValue("alex@example.com");
        PlaywrightAssertions.assertThat(largeFormPage.passwordInput).hasValue("TestPassword123");
        PlaywrightAssertions.assertThat(largeFormPage.nicknameInput).hasValue("TestNickname");

        PlaywrightAssertions.assertThat(largeFormPage.birthdayInput).hasValue("1990-01-15");
        PlaywrightAssertions.assertThat(largeFormPage.ageInput).hasValue("35");
        PlaywrightAssertions.assertThat(largeFormPage.languagesSelect).hasValue("English");
        PlaywrightAssertions.assertThat(largeFormPage.aboutYouInput)
                .hasValue("I am learning test automation.");

        PlaywrightAssertions.assertThat(largeFormPage.contactByPhone).isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.contactByEmail).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.doNotContact).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.automationInterest).isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.experienceSlider).hasValue("10");
        PlaywrightAssertions.assertThat(largeFormPage.experienceValue).hasText("10");

        PlaywrightAssertions.assertThat(largeFormPage.termsCheckbox).isChecked();

        largeFormPage.resetButton.click();
        PlaywrightAssertions.assertThat(largeFormPage.firstNameInput).hasValue("");
        PlaywrightAssertions.assertThat(largeFormPage.lastNameInput).hasValue("");
        PlaywrightAssertions.assertThat(largeFormPage.emailInput).hasValue("");
        PlaywrightAssertions.assertThat(largeFormPage.passwordInput).hasValue("");
        PlaywrightAssertions.assertThat(largeFormPage.nicknameInput).hasValue("");

        PlaywrightAssertions.assertThat(largeFormPage.birthdayInput).hasValue("");
        PlaywrightAssertions.assertThat(largeFormPage.ageInput).hasValue("");
        PlaywrightAssertions.assertThat(largeFormPage.countrySelect).hasValue(initialCountry);
        PlaywrightAssertions.assertThat(largeFormPage.languagesSelect).hasValue(initialLanguages);
        PlaywrightAssertions.assertThat(largeFormPage.aboutYouInput).hasValue("");

    PlaywrightAssertions.assertThat(largeFormPage.contactByEmail).isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.contactByPhone).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.doNotContact).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.testingInterest).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.automationInterest).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.devOpsInterest).not().isChecked();
        PlaywrightAssertions.assertThat(largeFormPage.experienceSlider).hasValue("5");
        //PlaywrightAssertions.assertThat(largeFormPage.experienceValue).hasText("5");
        Assertions.assertEquals("#e2231a", largeFormPage.favoriteColorInput.inputValue());

        PlaywrightAssertions.assertThat(largeFormPage.termsCheckbox).not().isChecked();
    }
}
