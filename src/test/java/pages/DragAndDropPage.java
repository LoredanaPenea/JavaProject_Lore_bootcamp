package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(Page page) {
        super(page);
    }
    public Locator columnA = page.locator("#column-a");
    public Locator columnB = page.locator("#column-b");
}
