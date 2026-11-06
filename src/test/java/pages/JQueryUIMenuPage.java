package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class JQueryUIMenuPage extends BasePage{
    public JQueryUIMenuPage(Page page) {
        super(page);
    }

    public Locator enabledItem = page.locator("#menu").getByText("Enabled", new Locator.GetByTextOptions().setExact(true));

    public Locator downloadsItem = page.locator("#menu").getByText("Downloads", new Locator.GetByTextOptions().setExact(true));

    public Locator pdfItem = page.locator("#menu").getByText("PDF", new Locator.GetByTextOptions().setExact(true));
    public Locator xlsItem = page.locator("#menu").getByText("Excel", new Locator.GetByTextOptions().setExact(true));

    public Locator backToJQueryUiItem = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Back to JQuery UI").setExact(true));

}
