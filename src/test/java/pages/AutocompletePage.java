package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AutocompletePage extends BasePage{
    public AutocompletePage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Autocomplete").setExact(true));
    public Locator fruitInput = page.locator("#autocomplete");
    public Locator suggestions = page.locator("#suggestions");
    public Locator suggestionOptions = page.getByRole(AriaRole.OPTION);

    public Locator appleSuggestion = page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Apple").setExact(true));
    public Locator status = page.locator("#status");
    public Locator selectedText = page.locator("#selected");
}
