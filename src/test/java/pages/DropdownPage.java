package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DropdownPage extends BasePage {
    public DropdownPage(Page page) {
        super(page);
    }
    public Locator dropdown = page.locator("#dropdown");
}
