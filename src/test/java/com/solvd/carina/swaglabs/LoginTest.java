package com.solvd.carina.swaglabs;

import com.solvd.carina.swaglabs.constants.UserData;
import com.solvd.carina.swaglabs.pages.common.LoginPageBase;
import com.solvd.carina.swaglabs.pages.common.ProductListPageBase;
import com.solvd.carina.swaglabs.pages.common.SideNavMenuBasePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends SwagLabsAbstractTest {

    //    @DataProvider
//    public Object[][] userData() {
//        return new Object[][]{
//                new Object[]{UserData.VALID_USER, UserData.VALID_PASS, false},
//                new Object[]{UserData.INVALID_USER, UserData.INVALID_PASS, true},
//        };
//    }
//
//    @Test(dataProvider = "userData")
//    @MethodOwner(owner = "mchutt")
//    public void verifyLoginWithValidCredentialsTest(String username, String password, boolean errorMessage) {
//        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
//        ProductListPageBase productListPage = loginPage.login(username, password);
//        if (errorMessage){
//            Assert.assertTrue(loginPage.isErrorMessagePresent(), "The error message for invalid credentials is not present");
//        }else {
//            Assert.assertTrue(productListPage.isPageOpened(), "Product List Page is not opened!");
//        }
//    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyLoginWithValidCredentialsTest() {
        ProductListPageBase productListPage = login();
        Assert.assertTrue(productListPage.isPageOpened(), "Product List Page is not opened!");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyLoginWithInvalidCredentials() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.login(UserData.INVALID_USER, UserData.INVALID_PASS);
        Assert.assertTrue(loginPage.isErrorMessagePresent(), "The error message for invalid credentials is not present");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyLogout() {
        ProductListPageBase productListPage = login();
        Assert.assertTrue(productListPage.isPageOpened(), "Products page is not opened!");

        SideNavMenuBasePage menu = productListPage.getHeader().openMenu();
        LoginPageBase loginPage = menu.clickOnLogoutBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened!");
    }
}
