package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class InputsPage extends BasePage{
    public InputsPage(Page page) {
        super(page);
    }

    public Locator numberInput = page.locator("input[type='number']");
}
