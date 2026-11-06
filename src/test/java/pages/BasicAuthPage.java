package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class BasicAuthPage extends BasePage{
    public BasicAuthPage (Page page){
        super(page);
    }
    //locators
    public Locator getBasicAuthHeading = page.getByRole(AriaRole.HEADING,
            new Page.GetByRoleOptions().setName("Basic Auth"));
    public Locator basicAuthText = page.getByText("Congratulations! You must have the proper credentials.");

    public Locator locatorBody = page.locator("body");

}
