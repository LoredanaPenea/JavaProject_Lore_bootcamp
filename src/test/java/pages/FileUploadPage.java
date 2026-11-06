package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class FileUploadPage extends BasePage {
    public FileUploadPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("File Uploader").setExact(true));
    public Locator fileInput = page.locator("#file-upload");
    public Locator uploadBtn = page.locator("#file-submit");
    public Locator successHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("File Uploaded!").setExact(true));
    public Locator uploadedFiles = page.locator("#uploaded-files");
    public Locator errorHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Internal Server Error").setExact(true));
}
