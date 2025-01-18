package com.solvd.carina.swaglabs.components.ios;

import com.solvd.carina.swaglabs.components.common.HeaderComponentBase;
import com.solvd.carina.swaglabs.pages.common.CartPageBase;
import com.solvd.carina.swaglabs.pages.common.SideNavMenuBasePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class IOSHeader extends HeaderComponentBase {

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cartBtn;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuBtn;

    public IOSHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CartPageBase openCart(){
        int x = cartBtn.getLocation().x;
        int y = cartBtn.getLocation().y;

        int hDividedBy2 = cartBtn.getSize().height / 2;
        int wDividedBy2 = cartBtn.getSize().width / 2;

        tap(x + wDividedBy2, y + hDividedBy2 + 10);
        return initPage(driver, CartPageBase.class);
    }

    @Override
    public SideNavMenuBasePage openMenu(){
        int x = menuBtn.getLocation().x;
        int y = menuBtn.getLocation().y;

        int hDividedBy2 = menuBtn.getSize().height / 2;
        int wDividedBy2 = menuBtn.getSize().width / 2;

        tap(x + wDividedBy2, y + hDividedBy2 + 10);
        return new SideNavMenuBasePage(driver);
    }
}
