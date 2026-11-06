package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HoversPage extends BasePage {
    public HoversPage(Page page) {
        super(page);
    }

    public Locator figures = page.locator(".figure");
    public Locator firstFigure = page.locator(".figure").nth(0);
    public Locator secondFigure = page.locator(".figure").nth(1);
    public Locator thirdFigure = page.locator(".figure").nth(2);
}
