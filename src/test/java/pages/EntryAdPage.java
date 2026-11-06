package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class EntryAdPage extends BasePage {
    public EntryAdPage(Page page) {
        super(page);
    }

    public Locator modal = page.locator("#modal");
    public Locator modalTitle = modal.locator(".modal-title h3");
    public Locator modalBody = modal.locator(".modal-body");
    public Locator closeBtn = modal.locator(".modal-footer p");
    public Locator restartAdLink = page.locator("#restart-ad");
}
