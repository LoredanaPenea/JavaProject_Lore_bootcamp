package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class FramesPage extends BasePage {
    public FramesPage(Page page) {
        super(page);
    }
    public Locator nestedFramesLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Nested Frames"));
    public Locator leftFrameBody = page.frameLocator("frame[name='frame-top']").frameLocator("frame[name='frame-left']")
            .locator("body");
    public Locator middleFrameBody = page.frameLocator("frame[name='frame-top']").frameLocator("frame[name='frame-middle']")
            .locator("body");
    public Locator rightFrameBody = page.frameLocator("frame[name='frame-top']").frameLocator("frame[name='frame-right']")
            .locator("body");
    public Locator bottomFrameBody = page.frameLocator("frame[name='frame-bottom']")
            .locator("body");

    public Locator iframeLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("iFrame"));
    // TinyMCE editor is inside this iframe.
    public Locator editorBody = page.frameLocator("#mce_0_ifr").locator("#tinymce");
}
