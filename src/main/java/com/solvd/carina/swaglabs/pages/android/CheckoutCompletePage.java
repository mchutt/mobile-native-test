package com.solvd.carina.swaglabs.pages.android;

import com.solvd.carina.swaglabs.pages.common.CheckoutCompletePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutCompletePageBase.class)
public class CheckoutCompletePage extends CheckoutCompletePageBase {

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().text(\"CHECKOUT: COMPLETE!\")")
    private ExtendedWebElement title;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

}
