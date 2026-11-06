package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ABTestingPage extends BasePage{

    public ABTestingPage(Page page) {
        super(page);
    }
    //public Locator abTestingText = page.getByText("");
    public Locator getAbTestingHeader = page.getByRole(AriaRole.HEADING);

}
