package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class BrokenImagesPage extends BasePage{
    public BrokenImagesPage (Page page){
        super(page);
    }
    // locators for images
   public Locator brokenImagesHeading = page.getByRole(AriaRole.HEADING,
            new Page.GetByRoleOptions().setName("Broken Images"));
   public Locator locatorImages = page.locator("#content div.example img");
   //public int numberOfImages = locatorImages.count();

    public boolean isImageLoaded(int index) {
        Object result = locatorImages.nth(index).evaluate("(img) => img.complete && img.naturalWidth > 0");
        return (Boolean) result;
    }

}
