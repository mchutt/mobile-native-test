package com.solvd.carina.swaglabs.pages.ios;

import com.solvd.carina.swaglabs.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutOverviewPageBase.class)
public class CheckoutOverviewPage extends CheckoutOverviewPageBase {

    @ExtendedFindBy(iosPredicate = "name == 'CHECKOUT: OVERVIEW' AND label == 'CHECKOUT: OVERVIEW' AND value == 'CHECKOUT: OVERVIEW'")
    private ExtendedWebElement title;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }
}
