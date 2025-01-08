package com.solvd.carina.swaglabs.pages.android;

import com.solvd.carina.swaglabs.pages.common.CheckoutCompletePageBase;
import com.solvd.carina.swaglabs.pages.common.CheckoutOverviewPageBase;
import com.solvd.carina.swaglabs.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutOverviewPageBase.class)
public class CheckoutOverviewPage extends CheckoutOverviewPageBase {

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().text(\"CHECKOUT: OVERVIEW\")")
    private ExtendedWebElement title;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"test-CANCEL\")")
    private ExtendedWebElement cancelBtn;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().text(\"FINISH\")")
    private ExtendedWebElement finishBtn;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    @Override
    public CheckoutCompletePageBase clickOnFinishBtn() {
        swipe(finishBtn);
        tap(finishBtn);
        return initPage(driver, CheckoutCompletePageBase.class);
    }

    @Override
    public ProductsPageBase clickOnCancelBtn() {
        swipe(cancelBtn);
        tap(cancelBtn);
        return initPage(driver, ProductsPageBase.class);
    }
}
