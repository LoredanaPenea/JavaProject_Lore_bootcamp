package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class JavaScriptAlertsPage extends BasePage {
    public JavaScriptAlertsPage(Page page) {
        super(page);
    }

    public Locator alertButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Alert"));
    public Locator confirmButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Confirm"));
    public Locator promptButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Prompt"));

    public Locator resultText = page.locator("#result");

}
