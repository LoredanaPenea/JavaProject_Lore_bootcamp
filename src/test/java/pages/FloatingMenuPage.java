package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class FloatingMenuPage extends BasePage {
    public FloatingMenuPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Floating Menu").setExact(true));
    public Locator menu = page.locator("#menu");
    public Locator homeLink = menu.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Home").setExact(true));
    public Locator newsLink = menu.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("News").setExact(true));
    public Locator contactLink = menu.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Contact").setExact(true));
    public Locator aboutLink = menu.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("About").setExact(true));
}
