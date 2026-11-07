package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ReadonlyInputsPage extends BasePage {
    public ReadonlyInputsPage(Page page) {
        super(page);
    }
    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Read-only Inputs").setExact(true));
    public Locator readOnlyCheckbox = page.locator("#checkbox");
    public Locator toggleTextInput = page.locator("#textfield");
    public Locator alwaysReadOnlyInput = page.locator("#always-readonly");
    public Locator disabledInput = page.locator("input:disabled");
}
