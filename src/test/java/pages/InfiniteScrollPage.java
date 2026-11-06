package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class InfiniteScrollPage extends BasePage{
    public InfiniteScrollPage(Page page) {
        super(page);
    }

    public Locator addedContent = page.locator(".jscroll-added");
}
