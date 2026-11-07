package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class RedirectLinkPage extends BasePage {
    public RedirectLinkPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Redirection").setExact(true));
    public Locator triggerRedirectLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("here").setExact(true));

}
