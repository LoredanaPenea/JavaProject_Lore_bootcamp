package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ExitIntentPage extends BasePage {
    public ExitIntentPage(Page page) {
        super(page);
    }

    public Locator modal = page.locator("#ouibounce-modal");
    public Locator modalTitle = modal.locator(".modal-title h3");
    public Locator modalBody = modal.locator(".modal-body");
    public Locator closeBtn = modal.locator(".modal-footer p");

    public void triggerExitIntent() {
        // Repeat the mouse movement until the page's delayed exit listener is ready.
        page.waitForCondition(() -> {
            if (modal.isVisible()) {
                return true;
            }
            page.mouse().move(300, 300);
            page.mouse().move(300, -1);
            return modal.isVisible();
        }, new Page.WaitForConditionOptions().setTimeout(10000));
    }
}
