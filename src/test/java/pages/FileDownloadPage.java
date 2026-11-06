package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class FileDownloadPage extends BasePage {
    public FileDownloadPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("File Downloader").setExact(true));
    public Locator fileLinks = page.locator(".example a");

    public Locator fileLink(String fileName) {
        return page.locator(".example").getByRole(AriaRole.LINK,
                new Locator.GetByRoleOptions().setName(fileName).setExact(true));
    }
}
