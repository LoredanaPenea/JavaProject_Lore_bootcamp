package tests;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pages.BrowserPermissionsPage;
import pages.MainPage;

import java.util.List;

public class BrowserPermissionsTests extends BaseTest{
    @Test
     void browserPermissionsTest(){
        MainPage mainPage = new MainPage(page);
        mainPage.browserPermissionsLink.click();

        BrowserPermissionsPage permissionsPage = new BrowserPermissionsPage(page);
        PlaywrightAssertions.assertThat(permissionsPage.heading).isVisible();
        PlaywrightAssertions.assertThat(permissionsPage.notificationsState).hasText("prompt");
        PlaywrightAssertions.assertThat(permissionsPage.clipboardReadState).hasText("prompt");

        context.grantPermissions(List.of("notifications", "clipboard-read", "clipboard-write"),
                new BrowserContext.GrantPermissionsOptions()
                        .setOrigin("https://the-internet.herokuapp.com"));
        page.reload();

        permissionsPage.askNotificationsButton.click();
        PlaywrightAssertions.assertThat(permissionsPage.notificationsResult)
                .hasText("Notifications: granted");

        permissionsPage.clipboardTextInput.fill("Playwright clipboard test");
        permissionsPage.copyButton.click();
        PlaywrightAssertions.assertThat(permissionsPage.clipboardResult)
                .hasText("Copied: Playwright clipboard test");

        permissionsPage.pasteButton.click();
        PlaywrightAssertions.assertThat(permissionsPage.clipboardResult)
                .hasText("Pasted: Playwright clipboard test");

    }

    @Test
    void cameraCanBeStartedAndStopped() {
        context.grantPermissions(List.of("camera"), new BrowserContext.GrantPermissionsOptions()
                        .setOrigin("https://the-internet.herokuapp.com"));

        MainPage mainPage = new MainPage(page);
        mainPage.browserPermissionsLink.click();

        BrowserPermissionsPage permissionsPage = new BrowserPermissionsPage(page);
        PlaywrightAssertions.assertThat(permissionsPage.heading).isVisible();
        PlaywrightAssertions.assertThat(permissionsPage.cameraState).hasText("granted");

        permissionsPage.startCameraButton.click();
        PlaywrightAssertions.assertThat(permissionsPage.cameraResult).containsText("Camera on:");

        permissionsPage.stopCameraButton.click();
        PlaywrightAssertions.assertThat(permissionsPage.cameraResult).hasText("Camera off");
    }

}
