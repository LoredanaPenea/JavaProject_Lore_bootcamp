package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ShiftingContentPage extends BasePage {
    public ShiftingContentPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Shifting Content").setExact(true));
    public Locator menuExampleLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Example 1: Menu Element").setExact(true));
    public Locator imageExampleLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Example 2: An image").setExact(true));
    public Locator listExampleLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Example 3: List").setExact(true));

    public Locator shiftedMenuLink = page.locator(".example a.shift");
    public Locator shiftedImage = page.locator(".example img.shift");

}
