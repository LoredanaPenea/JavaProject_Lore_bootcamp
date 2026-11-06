package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.Locator;

public class AddRemoveElementsPage extends BasePage {
    public AddRemoveElementsPage(Page page) {
        super(page);
    }

    public Locator addElementBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Element"));
    public Locator deleteBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Delete"));
}
