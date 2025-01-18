package com.solvd.carina.swaglabs.pages.android;

import com.solvd.carina.swaglabs.components.android.CartItem;
import com.solvd.carina.swaglabs.components.common.CartItemBase;
import com.solvd.carina.swaglabs.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().text(\"YOUR CART\")")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
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
