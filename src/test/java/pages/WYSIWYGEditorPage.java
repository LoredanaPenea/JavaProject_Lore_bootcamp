package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class WYSIWYGEditorPage extends BasePage{
    public WYSIWYGEditorPage (Page page){
        super(page);
    }
    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("An iFrame containing the TinyMCE WYSIWYG Editor"));
    public Locator editorBody = page.frameLocator("#mce_0_ifr").locator("body#tinymce");
}
