package com.solvd.carina.swaglabs.components.ios;

import com.solvd.carina.swaglabs.components.common.SortModalBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class SortModal extends SortModalBase implements IMobileUtils {

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

    @Override
    public void sortByNameAToZ() {
        tap(nameAToZ);
    }

    @Override
    public void sortByNameZToA() {
        tap(nameZToA);
    }

    @Override
    public void sortByPriceLowToHigh() {
        tap(priceLowToHigh);
    }

    @Override
    public void sortByPriceHighToLow() {
        tap(priceHighToLow);
    }

}
