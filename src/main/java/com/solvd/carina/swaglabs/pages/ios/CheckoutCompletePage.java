package com.solvd.carina.swaglabs.pages.ios;

import com.solvd.carina.swaglabs.pages.common.CheckoutCompletePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutCompletePageBase.class)
public class CheckoutCompletePage extends CheckoutCompletePageBase {

    @ExtendedFindBy(iosPredicate = "name == 'CHECKOUT: COMPLETE!' AND label == 'CHECKOUT: COMPLETE!' AND value == 'CHECKOUT: COMPLETE!'")
    private ExtendedWebElement title;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

}
