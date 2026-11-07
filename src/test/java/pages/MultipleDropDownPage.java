package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class MultipleDropDownPage extends BasePage {
    public MultipleDropDownPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions()
                    .setName("Multiple Select Dropdown List").setExact(true));

    public Locator multiSelect = page.locator("select[multiple]");
    public Locator options = multiSelect.locator("option");
    public Locator selectedOptions = multiSelect.locator("option:checked");
}
