package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class KeyPressesPage extends BasePage {
    public KeyPressesPage(Page page){
        super(page);
    }
    public Locator input = page.locator("#target");
    public Locator result = page.locator("#result");
}
