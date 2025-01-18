package com.solvd.carina.swaglabs.components.android;

import com.solvd.carina.swaglabs.components.common.HeaderComponentBase;
import com.solvd.carina.swaglabs.pages.common.SideNavMenuBasePage;
import com.solvd.carina.swaglabs.pages.common.CartPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class AndroidHeader extends HeaderComponentBase {
    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"test-Cart\").childSelector(new UiSelector().classNameMatches(\".*Text.*\"))")
    private ExtendedWebElement cartBtn;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"test-Menu\")")
    private ExtendedWebElement menuBtn;

    public AndroidHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CartPageBase openCart() {
        cartBtn.click();
        return initPage(driver, CartPageBase.class);
    }

    @Override
    public SideNavMenuBasePage openMenu() {
        menuBtn.click();
        return new SideNavMenuBasePage(driver);
    }
}
