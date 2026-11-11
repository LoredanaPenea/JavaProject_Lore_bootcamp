package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class BrowserPermissionsPage extends BasePage {
    public BrowserPermissionsPage(Page page) {
        super(page);
    }

    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Browser Permissions").setExact(true));
    public Locator geolocationState = page.locator("#state-geolocation");
    public Locator notificationsState = page.locator("#state-notifications");
    public Locator cameraState = page.locator("#state-camera");
    public Locator microphoneState = page.locator("#state-microphone");
    public Locator clipboardReadState = page.locator("#state-clipboard-read");
    public Locator askNotificationsButton = page.locator("#ask-notifications");
    public Locator notificationsResult = page.locator("#notifications-result");
    public Locator clipboardTextInput = page.locator("#clipboard-text");
    public Locator copyButton = page.locator("#copy");
    public Locator pasteButton = page.locator("#paste");
    public Locator clipboardResult = page.locator("#clipboard-result");
    public Locator startCameraButton = page.locator("#start-camera");
    public Locator stopCameraButton = page.locator("#stop-camera");
    public Locator cameraResult = page.locator("#camera-result");
    public Locator cameraVideo = page.locator("#camera-video");
}
