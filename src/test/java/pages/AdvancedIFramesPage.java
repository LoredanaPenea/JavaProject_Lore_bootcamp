package pages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AdvancedIFramesPage extends BasePage{
    public AdvancedIFramesPage(Page page){
        super(page);
    }
    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Advanced Iframes").setExact(true));
    public Locator parentAccess = page.locator("#parent-access");
    public Locator messageLog = page.locator("#message-log");

    public FrameLocator sandboxedFrame = page.frameLocator("#sandboxed-frame");
    public Locator sandboxedSendMessageButton = sandboxedFrame.getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Send a message to the page").setExact(true));

    public FrameLocator srcdocFrame = page.frameLocator("#srcdoc-frame");
    public Locator srcdocText = srcdocFrame.locator("#srcdoc-text");
    public Locator srcdocInput = srcdocFrame.locator("#srcdoc-input");

    public FrameLocator shadowFrame = page.frameLocator("#frame-host iframe#shadow-frame");
    public Locator shadowSendMessageButton = shadowFrame.getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Send a message to the page").setExact(true));
}
