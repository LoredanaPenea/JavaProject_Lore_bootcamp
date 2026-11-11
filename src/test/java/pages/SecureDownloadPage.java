package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SecureDownloadPage extends BasePage {
    public SecureDownloadPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Secure File Downloader").setExact(true));
    public Locator downloadLinks = page.locator("#content .example a[href^='download_secure/']");
    public Locator someFileLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("some-file.txt").setExact(true));

}
