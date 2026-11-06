package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckboxesPage extends BasePage{
    public CheckboxesPage (Page page ){
        super (page);
    }

    public Locator checkboxes = page.locator("#content .example input[type='checkbox']");
    public Locator checkbox1 = checkboxes.nth(0);
    public Locator checkbox2 = checkboxes.nth(1);

}
