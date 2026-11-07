package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class NestedFramesPage extends BasePage{
    public NestedFramesPage(Page page) {
        super(page);
    }

    public Locator leftFrameBody = page.frameLocator("frame[name='frame-top']")
            .frameLocator("frame[name='frame-left']").locator("body");

    public Locator middleFrameBody = page.frameLocator("frame[name='frame-top']")
            .frameLocator("frame[name='frame-middle']").locator("body");

    public Locator rightFrameBody = page.frameLocator("frame[name='frame-top']")
            .frameLocator("frame[name='frame-right']").locator("body");

    public Locator bottomFrameBody = page.frameLocator("frame[name='frame-bottom']")
            .locator("body");
}
