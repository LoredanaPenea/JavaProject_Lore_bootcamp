package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ShiftingContentImagePage extends BasePage {
    public ShiftingContentImagePage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Shifting Content: Image").setExact(true));
    public Locator randomModeLink = page.locator("a[href='/shifting_content/image?mode=random']");
    public Locator pixelShift100Link = page.locator("a[href='/shifting_content/image?pixel_shift=100']");
    public Locator randomModeAndPixelShiftLink = page.locator("a[href='/shifting_content/image?mode=random&pixel_shift=100']");
    public Locator simpleImageLink = page.locator("a[href='/shifting_content/image?image_type=simple']");

}
