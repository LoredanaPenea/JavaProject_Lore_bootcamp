package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HorizontalSliderPage extends BasePage {
    public HorizontalSliderPage(Page page) {
        super(page);
    }

    public Locator slider = page.getByRole(AriaRole.SLIDER);
    public Locator sliderValue = page.locator("#range");
}
