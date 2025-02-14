package com.solvd.carina.swaglabs.components.ios;

import com.solvd.carina.swaglabs.components.common.HeaderComponentBase;
import com.solvd.carina.swaglabs.pages.common.CartPageBase;
import com.solvd.carina.swaglabs.pages.common.SideNavMenuBasePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class IOSHeader extends HeaderComponentBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(IOSHeader.class);

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cartBtn;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuBtn;

    public IOSHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CartPageBase openCart() {
        safeTap(cartBtn);
        return initPage(driver, CartPageBase.class);
    }

    @Override
    public SideNavMenuBasePage openMenu() {
        safeTap(menuBtn);
        return new SideNavMenuBasePage(driver);
    }


    // helper methods
    private void safeTap(ExtendedWebElement button) {
        String deviceName = getDevice().getName();
        if (Objects.equals(deviceName, "iPhone 16") || Objects.equals(deviceName, "\"iPhone 16\"")) {
            tapByCoordinates(button);
        } else {
            button.click();
        }
    }

    private void tapByCoordinates(ExtendedWebElement button) {
        LOGGER.info("Tap on {} by coordinates." , button);
        int x = button.getLocation().x;
        int y = button.getLocation().y;
        int hDividedBy2 = button.getSize().height / 2;
        int wDividedBy2 = button.getSize().width / 2;
        tap(x + wDividedBy2, y + hDividedBy2 + 10);
    }
}
