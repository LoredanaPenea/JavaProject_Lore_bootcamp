package tests;

import org.junit.jupiter.api.Test;
import pages.GetByRolePage;

public class GetByRoleTests extends BaseTest{
    @Test
    void GetByRoleTest(){
        GetByRolePage getByRolePage = new GetByRolePage(page);
        getByRolePage.goodLocator.click();
    }
}
