package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ToastsPage extends BasePage
{
    public ToastsPage(Page page){
        super(page);
    }
    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Toasts").setExact(true));
    public Locator durationInput = page.getByLabel("Time on screen (milliseconds)", new Page.GetByLabelOptions().setExact(true));
    public Locator successToastButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Show success toast").setExact(true));
    public Locator errorToastButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Show error toast").setExact(true));
    public Locator infoToastButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Show info toast").setExact(true));
    public Locator toastsCount = page.locator("#toast-count");
    public Locator successToast = page.locator(".toast.toast-success");
    public Locator errorToast = page.locator(".toast.toast-error");
    public Locator infoToast = page.locator(".toast.toast-info");

}
