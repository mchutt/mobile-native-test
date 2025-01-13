package com.solvd.carina.swaglabs;

import com.solvd.carina.swaglabs.constants.UserData;
import com.solvd.carina.swaglabs.pages.common.LoginPageBase;
import com.solvd.carina.swaglabs.pages.common.ProductListPageBase;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;

public abstract class SwagLabsAbstractTest extends AbstractTest {

    ProductListPageBase login() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productListPage = loginPage.login(UserData.VALID_USER, UserData.VALID_PASS);
        Assert.assertTrue(productListPage.isPageOpened(), "Products page is not opened!");
        return productListPage;
    }
}
