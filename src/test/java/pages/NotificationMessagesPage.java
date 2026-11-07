package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class NotificationMessagesPage extends BasePage {
    public NotificationMessagesPage (Page page){
        super(page);
    }
    public Locator notificationMessage = page.locator("#flash");
    public Locator clickHereLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Click here").setExact(true));
}
