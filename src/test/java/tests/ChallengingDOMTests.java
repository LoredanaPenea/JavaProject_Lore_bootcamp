package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ChallengingDOMPage;
import pages.MainPage;

public class ChallengingDOMTests extends BaseTest
{
    @Test
     void challengingDOMTests() {
        MainPage mainPage = new MainPage(page);
        mainPage.challengingDOMLink.click();

        ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage(page);

        Assertions.assertTrue(challengingDOMPage.headingDOM.isVisible());
        Assertions.assertEquals(3, challengingDOMPage.buttons.count());
    }
}
