package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LocatorPage extends BasePage{
    public LocatorPage(Page page) {
        super(page);
    }

    //id
    public Locator idLocator = page.locator("#content");

    //text
    public Locator locatorText = page.locator("text=A/B Testing");

    //tag + text
    public Locator locatorTagText = page.locator("a:has-text('A/B Testing')");

    //tag + exact text
    public Locator locatorExactText = page.locator("a:text-is('A/B Testing')");

    //tag - non usual
    public Locator locatorTag = page.locator("a");

    //class - non usual
    public  Locator locatorClass = page.locator(".large-12 columns");

    //attribute - non usual
    public Locator locatorAttribute = page.locator("[href='/abtest']");

    // text regex
    public Locator locatorTextRegex = page.locator("text-matches(A/B.*)");

    // nth-child
    public Locator locatorNthChild = page.locator("a:nth-child(1)");

    //direct child
    public Locator locatorDirectChild = page.locator("div>a");

    //nth-type
    public Locator locatorNthType = page.locator("a:nth-of-type()");

    //nth-type -- to be verified ?
    public Locator locatorNthType2=page.locator("div:nth-of-type(2)");

    //first
    public Locator locatorFirstElement = page.locator("li").first();

    //last
    public Locator locatorLastElement = page.locator("li").last();
}
