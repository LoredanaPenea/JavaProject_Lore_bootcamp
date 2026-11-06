package tests;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ContextMenuPage;
import pages.MainPage;

import java.util.concurrent.atomic.AtomicReference;

import static com.microsoft.playwright.options.MouseButton.RIGHT;

public class ContextMenuTests extends BaseTest{
    @Test
    public void contextMenuTest(){
        MainPage mainPage = new MainPage(page);
        mainPage.contextMenuLink.click();

        ContextMenuPage contextMenuPage = new ContextMenuPage(page);
        AtomicReference<String> alertMessage = new AtomicReference<>();

        page.onceDialog((Dialog dialog) -> {
            alertMessage.set(dialog.message());
            dialog.accept();
        });

        contextMenuPage.contextMenuBox.click(new Locator.ClickOptions().setButton(RIGHT));
        Assertions.assertEquals("You selected a context menu", alertMessage.get());

    }
}
