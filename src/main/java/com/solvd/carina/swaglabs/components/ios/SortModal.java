package com.solvd.carina.swaglabs.components.ios;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class SortModal extends AbstractUIObject implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "Name (A to Z)")
    private ExtendedWebElement nameAToZ;

    @ExtendedFindBy(accessibilityId = "Name (Z to A)")
    private ExtendedWebElement nameZToA;

    @ExtendedFindBy(accessibilityId = "Price (low to high)")
    private ExtendedWebElement priceLowToHigh;

    @ExtendedFindBy(accessibilityId = "Price (high to low)")
    private ExtendedWebElement priceHighToLow;

    public SortModal(WebDriver driver) {
        super(driver);
    }

    public void sortByNameAToZ() {
        tap(nameAToZ);
    }

    public void sortByNameZToA() {
        tap(nameZToA);
    }

    public void sortByPriceLowToHigh() {
        tap(priceLowToHigh);
    }

    public void sortByPriceHighToLow() {
        tap(priceHighToLow);
    }

}
