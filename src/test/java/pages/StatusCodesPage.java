package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class StatusCodesPage extends BasePage {
    public StatusCodesPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Status Codes").setExact(true));
    public Locator code200Link = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("200").setExact(true));
    public Locator code301Link = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("301").setExact(true));
    public Locator code404Link = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("404").setExact(true));
    public Locator code500Link = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("500").setExact(true));
    public Locator hereLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("here").setExact(true));
}
