package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TwoFactorSecurePage extends BasePage{
    public TwoFactorSecurePage(Page page){
        super(page);
    }

    public Locator welcomeHeading = page.locator("h4.subheader");
    public Locator logoutLink = page.locator("a[href='/two_factor/logout']");
}
