package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ShiftingContentMenuPage extends BasePage {
    public ShiftingContentMenuPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Shifting Content: Menu Element").setExact(true));
    public Locator randomModeLink = page.locator("a[href='/shifting_content/menu?mode=random']");
    public Locator pixelShift100Link = page.locator("a[href='/shifting_content/menu?pixel_shift=100']");
    public Locator randomModeAndPixelShiftLink = page.locator("a[href='/shifting_content/menu?mode=random&pixel_shift=100']");
}
