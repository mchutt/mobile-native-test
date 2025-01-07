package com.solvd.carina.swaglabs.pages.common;

import com.solvd.carina.swaglabs.components.ios.CartItem;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CartPageBase extends AbstractPage implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    private ExtendedWebElement checkoutBtn;

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<CartItem> getCartItems();

    public abstract boolean isCartEmpty();

    public CheckoutPageBase clickOnCheckoutBtn(){
        swipe(checkoutBtn);
        tap(checkoutBtn);
        return initPage(driver, CheckoutPageBase.class);
    }
}
