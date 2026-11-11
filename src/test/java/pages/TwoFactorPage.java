package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TwoFactorPage extends BasePage{
    public TwoFactorPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Two-Factor Login").setExact(true));
    public Locator usernameInput = page.getByLabel("Username", new Page.GetByLabelOptions().setExact(true));
    public Locator passwordInput = page.getByLabel("Password", new Page.GetByLabelOptions().setExact(true));
    public Locator nextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next").setExact(true));

}
