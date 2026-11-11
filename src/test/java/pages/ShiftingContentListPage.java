package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ShiftingContentListPage extends BasePage {
    public ShiftingContentListPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Shifting Content: List").setExact(true));
    public Locator staticRecord = page.getByText("Important Information You're Looking For", new Page.GetByTextOptions().setExact(true));
    public Locator recordNesciunt = page.getByText("Nesciunt autem eum odit fuga tempora deleniti.", new Page.GetByTextOptions().setExact(true));
    public Locator recordSed = page.getByText("Sed deleniti blanditiis odio laudantium.", new Page.GetByTextOptions().setExact(true));
    public Locator recordVel = page.getByText("Vel aliquid dolores veniam enim nesciunt libero quaerat.", new Page.GetByTextOptions().setExact(true));
    public Locator recordEt = page.getByText("Et numquam et aliquam.", new Page.GetByTextOptions().setExact(true));
    public Locator listContent = page.locator("#content .example .large-6.columns.large-centered");

}
