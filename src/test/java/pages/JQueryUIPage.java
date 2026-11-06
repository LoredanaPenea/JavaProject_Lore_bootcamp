package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class JQueryUIPage extends BasePage{
    public JQueryUIPage (Page page){
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("JQuery UI").setExact(true));

    public Locator jqueryUiWebsiteLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions()
                    .setName("JQuery UI").setExact(true));

    public Locator menuLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions()
            .setName("Menu").setExact(true));

}
