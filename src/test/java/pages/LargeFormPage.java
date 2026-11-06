package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LargeFormPage extends BasePage{
    public LargeFormPage (Page page){
        super(page);
    }
    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Large Form").setExact(true));

    public Locator firstNameInput = page.getByLabel("First name", new Page.GetByLabelOptions().setExact(true));
    public Locator lastNameInput = page.getByLabel("Last name", new Page.GetByLabelOptions().setExact(true));
    public Locator emailInput = page.locator("input[name='email']");
    public Locator passwordInput = page.locator("input[name='password']");
    public Locator nicknameInput = page.getByPlaceholder("Nickname (optional)", new Page.GetByPlaceholderOptions().setExact(true));

    public Locator birthdayInput = page.getByLabel("Birthday", new Page.GetByLabelOptions().setExact(true));
    public Locator ageInput = page.locator("input[name='age']");
    public Locator countrySelect = page.getByLabel("Country", new Page.GetByLabelOptions().setExact(true));
    public Locator languagesSelect = page.locator("select[name='languages[]']");
    public Locator aboutYouInput = page.getByLabel("About you", new Page.GetByLabelOptions().setExact(true));

    public Locator contactByEmail = page.locator("input[name='contact'][value='email']");
    public Locator contactByPhone = page.locator("input[name='contact'][value='phone']");
    public Locator doNotContact = page.locator("input[name='contact'][value='none']");
    public Locator testingInterest = page.locator("input[name='interests[]'][value='testing']");
    public Locator automationInterest = page.locator("input[name='interests[]'][value='automation']");
    public Locator devOpsInterest = page.locator("input[name='interests[]'][value='devops']");
    public Locator experienceSlider = page.locator("#experience");
    public Locator experienceValue = page.locator("#experience-value");
    public Locator favoriteColorInput = page.locator("input[name='color']");

    public Locator termsCheckbox = page.getByLabel("I accept the terms", new Page.GetByLabelOptions().setExact(true));
    public Locator submitButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit").setExact(true));
    public Locator resetButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset").setExact(true));

    public Locator submittedHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Form Submitted").setExact(true));
    public Locator fieldColumnHeader = page.locator("table thead th").nth(0);
    public Locator valueColumnHeader = page.locator("table thead th").nth(1);
    public Locator submittedValuesTable = page.locator("table");
}
