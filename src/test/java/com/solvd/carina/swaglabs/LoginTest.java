package com.solvd.carina.swaglabs;

import com.solvd.carina.swaglabs.constants.UserData;
import com.solvd.carina.swaglabs.pages.common.LoginPageBase;
import com.solvd.carina.swaglabs.pages.common.ProductListPageBase;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends SwagLabsAbstractTest {

    @DataProvider
    public Object[][] userData() {
        return new Object[][]{
                new Object[]{UserData.VALID_USER, UserData.VALID_PASS, true},
                new Object[]{UserData.INVALID_USER, UserData.INVALID_PASS, false},
        };
    }

    @Test(dataProvider = "userData")
    @MethodOwner(owner = "mchutt")
    public void verifyLoginWithValidCredentialsTest(String username, String password, boolean isValid) {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productListPage = loginPage.login(username, password);
        if (isValid) {
            Assert.assertTrue(productListPage.isPageOpened(), "Product List Page is not opened!");
        } else {
            Assert.assertTrue(loginPage.isErrorMessagePresent(), "The error message for invalid credentials is not present");
        }
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyLogout() {
        ProductListPageBase productListPage = login();
        Assert.assertTrue(productListPage.isPageOpened(), "Products page is not opened!");
        LoginPageBase loginPage = productListPage.getHeader().openMenu().clickOnLogoutBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened!");
    }
}
