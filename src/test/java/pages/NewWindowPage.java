package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class NewWindowPage extends BasePage {
    public NewWindowPage (Page page){
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("New Window").setExact(true));
}
