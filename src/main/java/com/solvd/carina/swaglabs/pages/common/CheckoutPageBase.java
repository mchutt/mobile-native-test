package com.solvd.carina.swaglabs.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutPageBase extends AbstractPage {

    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CheckoutPageBase typeFirstName(String firstName);

    public abstract CheckoutPageBase typeLastName(String lastName);

    public abstract CheckoutPageBase typeZipCode(String zipCode);

    public abstract CheckoutOverviewPageBase clickContinue();

    public abstract boolean isFirstNameErrorMessageVisible();
}
