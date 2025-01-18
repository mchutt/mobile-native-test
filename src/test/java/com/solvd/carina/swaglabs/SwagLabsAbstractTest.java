package com.solvd.carina.swaglabs;

import com.solvd.carina.swaglabs.components.common.ProductCardComponentBase;
import com.solvd.carina.swaglabs.constants.UserData;
import com.solvd.carina.swaglabs.pages.common.LoginPageBase;
import com.solvd.carina.swaglabs.pages.common.ProductListPageBase;
import com.zebrunner.carina.core.AbstractTest;

public abstract class SwagLabsAbstractTest extends AbstractTest {

    ProductListPageBase login() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        return loginPage.login(UserData.VALID_USER, UserData.VALID_PASS);
    }

    ProductCardComponentBase addARandomProductToTheCart(ProductListPageBase productListPage) {
        ProductCardComponentBase product = productListPage.getARandomProduct();
        product.clickOnAddToCartBtn();
        return product;
    }
}
