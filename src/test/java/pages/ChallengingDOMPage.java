package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ChallengingDOMPage extends BasePage {
    public ChallengingDOMPage(Page page){
        super(page);
    }
   public Locator headingDOM = page.getByRole(AriaRole.HEADING,
            new Page.GetByRoleOptions().setName("Challenging DOM"));
   public Locator buttons = page.locator("#content .example a.button");
   public Locator blackButton = page.locator("#content .example a.button:not(.alert):not(.success)");
   public Locator redButton = page.locator("#content .example a.button.alert");
   public Locator greenButton = page.locator("#content .example a.button.success");
}
