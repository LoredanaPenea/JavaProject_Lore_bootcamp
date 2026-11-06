package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class GetByRolePage extends BasePage{

    public GetByRolePage(Page page) {
        super(page);
    }

//ARIA ROLE - values:
//    AriaRole.LINK
//    AriaRole.BUTTON
//    AriaRole.TEXTBOX
//    AriaRole.CHECKBOX
//    AriaRole.RADIO
//    AriaRole.COMBOBOX
//    AriaRole.HEADING
//    AriaRole.IMG
//    AriaRole.LIST
//    AriaRole.LISTITEM
//    AriaRole.TABLE
//    AriaRole.ROW
//    AriaRole.CELL

    public Locator goodLocator = page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("A/B Testing"));
    //page.getByRole(AriaRole.LINK); too general, wrong locator definition

    public Locator locatorRegex= page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("A/B.*"));

}
