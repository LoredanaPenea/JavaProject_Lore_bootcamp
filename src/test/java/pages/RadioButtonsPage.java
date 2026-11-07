package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class RadioButtonsPage extends BasePage {
    public RadioButtonsPage(Page page) {
        super(page);
    }
    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Radio Buttons").setExact(true));
    public Locator redRadio = page.locator("input[name='color'][value='red']");
    public Locator blueRadio = page.locator("input[name='color'][value='blue']");
    public Locator greenRadio = page.locator("input[name='color'][value='green']");
    public Locator footballRadio = page.locator("input[name='sport'][value='football']");
    public Locator tennisRadio = page.locator("input[name='sport'][value='tennis']");
    public Locator hockeyRadio = page.locator("input[name='sport'][value='hockey']");
    public Locator result = page.locator("#result");
}
