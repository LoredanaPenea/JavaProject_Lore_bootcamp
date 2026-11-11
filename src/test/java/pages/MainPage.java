package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class MainPage extends BasePage{

    public MainPage (Page page){
        super(page);
    }

    public Locator abTestingLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("A/B Testing"));
    public Locator addRemoveElements = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add/Remove Elements"));

    public Locator basicAuthLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Basic Auth"));
    public Locator brokenImages = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Broken Images"));
    public Locator canvasLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Canvas"));
    public Locator challengingDOMLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Challenging DOM"));
    public Locator checkboxeslink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Checkboxes"));
    public Locator contextMenuLink = page.locator("[href='/checkboxes']");
    public Locator digestAuthenticationLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Digest Authentication"));
    public Locator disappearingElementsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Disappearing Elements"));
    public Locator dragAndDropLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Drag and Drop"));
    public Locator dropdownLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dropdown").setExact(true));
    public Locator dynamicContentLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dynamic Content").setExact(true));
    public Locator dynamicControlsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dynamic Controls"));
    public Locator dynamicLoadingLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dynamic Loading"));
    public Locator entryAdLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Entry Ad").setExact(true));
    public Locator exitIntentLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Exit Intent").setExact(true));
    public Locator fileDownloadLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("File Download").setExact(true));
    public Locator fileUploadLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("File Upload").setExact(true));
    public Locator floatingMenuLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Floating Menu").setExact(true));
    public Locator forgotPasswordLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Forgot Password").setExact(true));
    public Locator formAuthenticationLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Form Authentication").setExact(true));
    public Locator framesLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Frames").setExact(true));
    public Locator geolocationLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Geolocation"));
    public Locator horizontalSliderLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Horizontal Slider").setExact(true));
    public Locator hoversLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Hovers"));
    public Locator infiniteScrollLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Infinite Scroll"));
    public Locator inputsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Inputs").setExact(true));
    public Locator jqueryUiMenusLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JQuery UI Menus").setExact(true));
    public Locator javascriptAlertsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JavaScript Alerts").setExact(true));
    public Locator javascriptOnLoadErrorLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JavaScript onload event error").setExact(true));
    public Locator keyPressesLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Key Presses").setExact(true));
    public Locator largeLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Large & Deep DOM").setExact(true));
    public Locator largeFormLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Large Form").setExact(true));
    public Locator multipleSelectDropDownLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Multiple Select Dropdown").setExact(true));
    public Locator multipleWindowsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Multiple Windows").setExact(true));
    public Locator nestedFramesLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Nested Frames").setExact(true));
    public Locator notificationMessagesLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Notification Messages").setExact(true));
    public Locator radioButtonsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Radio Buttons").setExact(true));
    public Locator readonlyInputsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Read-only Inputs").setExact(true));
    public Locator redirectLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Redirect Link").setExact(true));
    public Locator toastsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Toasts").setExact(true));
    public Locator wysiwygEditorLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("WYSIWYG Editor").setExact(true));
    public Locator datetimePickersLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Date & Time Pickers").setExact(true));
    public Locator twoFactorLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Two-Factor Login").setExact(true));
    public Locator advancedIframesLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Advanced Iframes").setExact(true));
    public Locator autocompleteLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Autocomplete").setExact(true));
    public Locator browserPermissionsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Browser Permissions").setExact(true));
    public Locator secureFileDownloadLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Secure File Download").setExact(true));
    public Locator shiftingContentLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Shifting Content").setExact(true));

    private Locator linkName(String name) {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(name));
    }

}
