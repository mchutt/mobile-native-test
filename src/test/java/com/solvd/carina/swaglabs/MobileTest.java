package com.solvd.carina.swaglabs;

import com.solvd.carina.swaglabs.components.common.MenuComponentBase;
import com.solvd.carina.swaglabs.components.ios.CartItem;
import com.solvd.carina.swaglabs.components.ios.ProductCardComponent;
import com.solvd.carina.swaglabs.constants.UserData;
import com.solvd.carina.swaglabs.pages.common.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.Screenshot;
import com.zebrunner.carina.webdriver.ScreenshotType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyLoginWithValidCredentialsTest() {
        loginWithValidCredentials();
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
        ProductsPageBase productsPage = loginWithValidCredentials();

        MenuComponentBase menu = productsPage.getHeader().openMenu();
        LoginPageBase loginPage = menu.clickOnLogoutBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened!");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyOpenProductDetails() {
        ProductsPageBase productsPage = loginWithValidCredentials();

        ProductCardComponent product = productsPage.getARandomProduct();
        String name = product.getProductName();
        String price = product.getProductPrice();

        ProductDetailsPageBase productDetailsPage = product.clickOnOpenDetails();
        String productName = productDetailsPage.getProductName();
        String productPrice = productDetailsPage.getProductPrice();

        Assert.assertEquals(productName, name, "The product names do not match!");
        Assert.assertEquals(productPrice, price, "The product prices do not match!");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifySortingProductsByPrice() {
        ProductsPageBase productsPage = loginWithValidCredentials();

        productsPage.openSortModal().sortByPriceLowToHigh();
        Assert.assertTrue(productsPage.isProductListSortedByPriceLowToHigh(), "Product list is not sorted by price in ascending order");

        productsPage.openSortModal().sortByPriceHighToLow();
        Assert.assertTrue(productsPage.isProductListSortedByPriceHighToLow(), "Product list is not sorted by price in descending order");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifySortingProductsByName() {
        ProductsPageBase productsPage = loginWithValidCredentials();

        productsPage.openSortModal().sortByNameAToZ();
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_FULL_SIZE, "after sorting by name from a to z");
        Assert.assertTrue(productsPage.isProductListSortedByNameAToZ(), "Product list is not sorted by name from a to z");

        productsPage.openSortModal().sortByNameZToA();
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_FULL_SIZE, "after sorting by name from z to a");
        Assert.assertTrue(productsPage.isProductListSortedByNameZToA(), "Product list is not sorted by name from z to a");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyAddAProductToTheCart() {
        ProductsPageBase productsPage = loginWithValidCredentials();

        addProductToCartAndVerify(productsPage);
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyAddAProductToTheCartAndRemoveIt() {
        ProductsPageBase productsPage = loginWithValidCredentials();

        CartItem cartItem = addProductToCartAndVerify(productsPage);
        cartItem.clickOnRemoveBtn();
        CartPageBase cartPage = initPage(getDriver(), CartPageBase.class);
        Assert.assertTrue(cartPage.isCartEmpty(), "The cart is not empty");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyCheckout() {
        ProductsPageBase productsPage = loginWithValidCredentials();

        productsPage.getARandomProduct().clickOnAddToCartBtn();
        CartPageBase cartPage = productsPage.getHeader().openCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened!");
        CheckoutOverviewPageBase checkoutOverviewPage = cartPage.clickOnCheckoutBtn()
                .typeFirstName(UserData.FIRST_NAME)
                .typeLastName(UserData.LAST_NAME)
                .typeZipCode(UserData.ZIP_CODE)
                .clickContinue();
        Assert.assertTrue(checkoutOverviewPage.isPageOpened(), "Checkout overview page is not opened!");
        CheckoutCompletePageBase checkoutCompletePage = checkoutOverviewPage.clickOnFinishBtn();
        Assert.assertTrue(checkoutCompletePage.isPageOpened(), "Checkout complete page is not opened!");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyCheckoutWithEmptyCardDetails() {
        ProductsPageBase productsPage = loginWithValidCredentials();

        ProductCardComponent product = productsPage.getARandomProduct();
        product.clickOnAddToCartBtn();
        CartPageBase cartPage = productsPage.getHeader().openCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened!");
        CheckoutPageBase checkoutPage = cartPage.clickOnCheckoutBtn();
        checkoutPage.clickContinue();
        Assert.assertTrue(checkoutPage.isFirstNameErrorMessageVisible(), "The message 'first name is required' is not visible!");
    }


    private ProductsPageBase loginWithValidCredentials() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductsPageBase productsPage = loginPage.login(UserData.VALID_USER, UserData.VALID_PASS);
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened!");
        return productsPage;
    }

    private CartItem addProductToCartAndVerify(ProductsPageBase productsPage) {
        ProductCardComponent product = productsPage.getARandomProduct();
        String productName = product.getProductName();
        product.clickOnAddToCartBtn();
        Assert.assertTrue(product.isRemoveFromCartBtnPresent(), "Button 'Remove' is not present!");
        CartPageBase cartPage = productsPage.getHeader().openCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened!");
        CartItem cartItem = cartPage.getCartItems().get(0);
        Assert.assertEquals(cartItem.getAmount(), 1, "The product amount do not match");
        Assert.assertEquals(cartItem.getName(), productName, "The product names do not match");
        return cartItem;
    }

}
