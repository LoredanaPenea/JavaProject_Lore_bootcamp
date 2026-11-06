package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ForgotPasswordPage extends BasePage {
    public ForgotPasswordPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Forgot Password"));
    public Locator emailInput = page.getByLabel("E-mail", new Page.GetByLabelOptions());
    public Locator retrievePasswordBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Retrieve password"));
    public Locator confirmationMessage = page.getByText("Your e-mail's been sent!", new Page.GetByTextOptions().setExact(true));

}
