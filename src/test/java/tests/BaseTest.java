package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {
    protected Playwright playwright;
    protected Browser  browser;
    protected BrowserContext context;
  //  protected BrowserContext secondContext;
    protected Page page;


    @BeforeEach
    void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/");
        //tab2=context.newPage();
        //tab2.navigate("https://www.google.com/");

    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

}
