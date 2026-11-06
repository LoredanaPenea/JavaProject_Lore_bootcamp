package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.regex.Pattern;

public class GetByTextPage extends BasePage{
    public GetByTextPage(Page page) {
        super(page);
    }

    public Locator locatorGetByText = page.getByText("A/B Testing");
    public Locator locatorNotExactMatch = page.getByText("Testing",new Page.GetByTextOptions().setExact(false));
    public Locator locatorRegex = page.getByText(Pattern.compile("^A/B Testing$"));
}
