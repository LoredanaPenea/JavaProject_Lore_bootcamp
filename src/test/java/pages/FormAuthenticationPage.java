package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class FormAuthenticationPage extends BasePage {
    public FormAuthenticationPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Login Page").setExact(true));
    public Locator usernameInput = page.getByLabel("Username", new Page.GetByLabelOptions().setExact(true));
    public Locator passwordInput = page.getByLabel("Password", new Page.GetByLabelOptions().setExact(true));
    public Locator loginBtn = page.locator("#login button[type='submit']");
    public Locator flashMessage = page.locator("#flash");
    public Locator secureAreaHeading = page.getByRole(AriaRole.HEADING,
            new Page.GetByRoleOptions().setName("Secure Area").setExact(true));
    public Locator logoutLink = page.locator(".example a[href='/logout']");

}
