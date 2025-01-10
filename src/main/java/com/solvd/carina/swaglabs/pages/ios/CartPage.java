package com.solvd.carina.swaglabs.pages.ios;

import com.solvd.carina.swaglabs.components.common.CartItemBase;
import com.solvd.carina.swaglabs.components.ios.CartItem;
import com.solvd.carina.swaglabs.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @ExtendedFindBy(iosPredicate = "name == 'YOUR CART' AND label == 'YOUR CART' AND value == 'YOUR CART'")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosPredicate = "name == 'test-Item'")
    private List<CartItem> cartItemList;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    @Override
    public List<? extends CartItemBase> getCartItems() {
        return cartItemList;
    }

    @Override
    public boolean isCartEmpty() {
        return cartItemList.isEmpty();
    }

}
