package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DynamicLoadingPage extends BasePage {
    public DynamicLoadingPage(Page page) {
        super(page);
    }

    public Locator example1Link = page.locator("a[href='/dynamic_loading/1']");
    public Locator example2Link = page.locator("a[href='/dynamic_loading/2']");
    public Locator startBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start").setExact(true));
    public Locator loading = page.locator("#loading");
    public Locator finishText = page.locator("#finish h4");
}
