package com.solvd.carina.swaglabs;

import com.solvd.carina.swaglabs.components.common.CartItemBase;
import com.solvd.carina.swaglabs.components.common.ProductCardComponentBase;
import com.solvd.carina.swaglabs.constants.UserData;
import com.solvd.carina.swaglabs.pages.common.*;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends SwagLabsAbstractTest {

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyOpenProductDetails() {
        ProductListPageBase productListPage = login();

        ProductCardComponentBase product = productListPage.getARandomProduct();
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
    public void verifyAddAProductToTheCart() {
        ProductListPageBase productListPage = login();

        addProductToCartAndVerify(productListPage);
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyAddAProductToTheCartAndRemoveIt() {
        ProductListPageBase productListPage = login();

        CartItemBase cartItem = addProductToCartAndVerify(productListPage);
        cartItem.clickOnRemoveBtn();
        CartPageBase cartPage = initPage(getDriver(), CartPageBase.class);
        Assert.assertTrue(cartPage.isCartEmpty(), "The cart is not empty");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyCheckout() {
        ProductListPageBase productListPage = login();

        productListPage.getARandomProduct().clickOnAddToCartBtn();
        CartPageBase cartPage = productListPage.getHeader().openCart();
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
        ProductListPageBase productListPage = login();

        ProductCardComponentBase product = productListPage.getARandomProduct();
        product.clickOnAddToCartBtn();
        CartPageBase cartPage = productListPage.getHeader().openCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened!");
        CheckoutPageBase checkoutPage = cartPage.clickOnCheckoutBtn();
        checkoutPage.clickContinue();
        Assert.assertTrue(checkoutPage.isFirstNameErrorMessageVisible(), "The message 'first name is required' is not visible!");
    }

    private CartItemBase addProductToCartAndVerify(ProductListPageBase productListPage) {
        ProductCardComponentBase product = productListPage.getARandomProduct();
        String productName = product.getProductName();
        product.clickOnAddToCartBtn();
        Assert.assertTrue(product.isRemoveFromCartBtnPresent(), "Button 'Remove' is not present!");
        CartPageBase cartPage = productListPage.getHeader().openCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened!");
        CartItemBase cartItem = cartPage.getCartItems().get(0);
        Assert.assertEquals(cartItem.getAmount(), 1, "The product amount do not match");
        Assert.assertEquals(cartItem.getName(), productName, "The product names do not match");
        return cartItem;
    }

}
