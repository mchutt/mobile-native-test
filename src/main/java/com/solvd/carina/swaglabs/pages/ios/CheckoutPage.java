package com.solvd.carina.swaglabs.pages.ios;

import com.solvd.carina.swaglabs.pages.common.CheckoutOverviewPageBase;
import com.solvd.carina.swaglabs.pages.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {

    @ExtendedFindBy(accessibilityId = "test-First Name")
    private ExtendedWebElement firstNameInput;

    @ExtendedFindBy(accessibilityId = "test-Last Name")
    private ExtendedWebElement lastNameInput;

    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    private ExtendedWebElement zipCodeInput;

    @ExtendedFindBy(accessibilityId = "test-CONTINUE")
    private ExtendedWebElement continueButton;

    @ExtendedFindBy(accessibilityId = "First Name is required")
    private ExtendedWebElement firstNameRequiredErrorMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutPageBase typeFirstName(String firstName) {
        firstNameInput.type(firstName);
        return this;
    }

    @Override
    public CheckoutPageBase typeLastName(String lastName) {
        lastNameInput.type(lastName);
        return this;
    }

    @Override
    public CheckoutPageBase typeZipCode(String zipCode) {
        zipCodeInput.type(zipCode);
        return this;
    }

    @Override
    public CheckoutOverviewPageBase clickContinue() {
        continueButton.click();
        return initPage(driver, CheckoutOverviewPageBase.class);
    }

    @Override
    public boolean isFirstNameErrorMessageVisible() {
        return firstNameRequiredErrorMessage.isVisible();
    }
}
