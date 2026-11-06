package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import pages.ABTestingPage;
import pages.MainPage;

public class ABTestingTests extends BaseTest{

    @Test
    void clickABTest(){
        MainPage mainPage = new MainPage(page);
        mainPage.abTestingLink.click();

        ABTestingPage abTestingPage = new ABTestingPage(page);
        Assertions.assertTrue(abTestingPage.getAbTestingHeader.isVisible(),"testing failed - has different header");
    }
}
