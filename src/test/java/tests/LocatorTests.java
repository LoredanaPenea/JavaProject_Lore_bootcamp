package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ABTestingPage;
import pages.LocatorPage;

public class LocatorTests extends BaseTest{
    @Test
    void locatorTest(){
        ABTestingPage abTestingPage = new ABTestingPage(page);
       // abTestingPage.abTestingLink.click();

        LocatorPage locatorPage = new LocatorPage(page);
        Assertions.assertTrue(locatorPage.idLocator.isVisible());
    }


}
