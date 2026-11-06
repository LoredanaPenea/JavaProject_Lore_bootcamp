package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LargePage extends BasePage {
    public LargePage (Page page){
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Large & Deep DOM").setExact(true));
    public Locator noSiblingsHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("No Siblings").setExact(true));
    public Locator siblingsHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Siblings").setExact(true));
    public Locator lastSibling = page.locator("#siblings").getByText("50.3", new Locator.GetByTextOptions().setExact(true));


    public Locator largeTable = page.locator("table");
    public Locator tableRows = largeTable.locator("tbody tr");
    public Locator tableCells = largeTable.locator("tbody td");
}
