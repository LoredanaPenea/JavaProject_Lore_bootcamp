package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import java.util.concurrent.atomic.AtomicReference;

public class JSOnLoadErrorTest extends BaseTest {
    @Test
    public void JSOnLoadErrorTest() {
        AtomicReference<String> pageError = new AtomicReference<>();
        page.onPageError(pageError::set);

        MainPage mainPage = new MainPage(page);
        mainPage.javascriptOnLoadErrorLink.click();

      //  JSOnLoadErrorPage jsOnLoadErrorPage = new JSOnLoadErrorPage(page);

        Assertions.assertEquals("function", page.evaluate("typeof loadError"));
        Assertions.assertNotNull(pageError.get(),
                "Expected a JavaScript error when the page loads");
        Assertions.assertTrue(pageError.get().contains("xyz"),
                "Expected the error to refer to the xyz property, but got: " + pageError.get());

        System.out.println("JavaScript page error: " + pageError.get());
    }
}
