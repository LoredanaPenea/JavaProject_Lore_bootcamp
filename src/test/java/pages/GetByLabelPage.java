package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class GetByLabelPage extends BasePage{
    public GetByLabelPage(Page page) {
        super(page);
    }

    public Locator locatorGetByLabel = page.getByLabel("username");

    public Locator locatorGetByPlaceholder = page.getByPlaceholder("username");

    //images
    public Locator locatorGetByAltText = page.getByPlaceholder("username");

    //getBy
}
