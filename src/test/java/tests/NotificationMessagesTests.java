package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.NotificationMessagesPage;

public class NotificationMessagesTests extends BaseTest{
    @Test
    public void notificationMessagesTest(){
        MainPage mainPage = new MainPage(page);
        mainPage.notificationMessagesLink.click();

        NotificationMessagesPage notificationMessagesPage = new NotificationMessagesPage(page);

        PlaywrightAssertions.assertThat(notificationMessagesPage.notificationMessage).isVisible();
        assertValidNotification(notificationMessagesPage.notificationMessage.innerText());
        System.out.println("Notification Message: " + notificationMessagesPage.notificationMessage.innerText());

        notificationMessagesPage.clickHereLink.click();

        PlaywrightAssertions.assertThat(notificationMessagesPage.notificationMessage).isVisible();
        assertValidNotification(notificationMessagesPage.notificationMessage.innerText());
        System.out.println("Notification Message: " + notificationMessagesPage.notificationMessage.innerText());

        notificationMessagesPage.clickHereLink.click();
        PlaywrightAssertions.assertThat(notificationMessagesPage.notificationMessage).isVisible();
        assertValidNotification(notificationMessagesPage.notificationMessage.innerText());
        System.out.println("Notification Message: " + notificationMessagesPage.notificationMessage.innerText());
    }

    private void assertValidNotification(String message) {
        String cleanedMessage = message.replace("×", "").trim();

        Assertions.assertTrue(cleanedMessage.equals("Action successful")
                        || cleanedMessage.startsWith("Action unsuccesful"),
                "Unexpected notification message: " + cleanedMessage);
    }
}
