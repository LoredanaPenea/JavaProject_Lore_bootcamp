package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DynamicContentPage extends BasePage {
    public DynamicContentPage(Page page) {
        super(page);
    }

    public Locator contentRows = page.locator("#content .large-10.columns .row");
    public Locator staticContentLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("click here"));

}