package com.solvd.carina.swaglabs.components.ios;

import com.solvd.carina.swaglabs.components.common.MenuComponentBase;
import com.solvd.carina.swaglabs.pages.common.CartPageBase;
import com.solvd.carina.swaglabs.pages.ios.CartPage;
import com.zebrunner.carina.utils.ios.IOSUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class Header extends AbstractUIObject implements IOSUtils, IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cartBtn;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuBtn;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPageBase openCart(){
        tap(357, 60);
        return new CartPage(driver);
    }

    public MenuComponentBase openMenu(){
        tap(30, 60);
        return new Menu(driver);
    }
}
